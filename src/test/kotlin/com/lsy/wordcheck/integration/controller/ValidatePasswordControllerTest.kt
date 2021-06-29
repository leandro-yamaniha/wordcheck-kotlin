package com.lsy.wordcheck.integration.controller

import com.lsy.wordcheck.controller.ApiControllerAdvice
import com.lsy.wordcheck.controller.ValidatePasswordController
import com.lsy.wordcheck.dto.PasswordDto
import com.lsy.wordcheck.utils.JsonUtils
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@SpringBootTest
class ValidatePasswordControllerTest {
    private val POST_VALIDATE_PASSWORD_ENDPOINT: String = ValidatePasswordController.BASE_ENDPOINT
        .plus(ValidatePasswordController.POST_VALIDATE_PASSWORD)

    @Autowired
    private val controller: ValidatePasswordController? = null

    private var mockMvc: MockMvc? = null

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders
            .standaloneSetup(controller)
            .setControllerAdvice(ApiControllerAdvice())
            .build()
    }

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["AbTp9!fok", "AbTp9!fok2"])
    @Throws(Exception::class)
    fun okWhenPassWordIsValid(password: String) {
        postValidatePassword(password)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value("true"))
    }

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(strings = ["", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok", "AbTp9!fok "])
    @Throws(
        Exception::class
    )
    fun okWhenPassWordIsInvalid(password: String) {
        postValidatePassword(password)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value("false"))
    }

    @Test
    @Throws(Exception::class)
    fun badRequestWhenMalformedRequestBody() {
        postValidatePasswordPayload("invalid")
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors.message").value("Malformed request body"))
    }

    @Throws(Exception::class)
    private fun postValidatePassword(password: String): ResultActions {
        return postValidatePasswordPayload(JsonUtils.toString(PasswordDto(password)))
    }

    @Throws(Exception::class)
    private fun postValidatePasswordPayload(request: String): ResultActions {
        return mockMvc!!.perform(
            MockMvcRequestBuilders.post(POST_VALIDATE_PASSWORD_ENDPOINT)
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request)
        )
    }
}
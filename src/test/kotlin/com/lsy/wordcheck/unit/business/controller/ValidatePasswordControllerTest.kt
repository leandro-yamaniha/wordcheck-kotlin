package com.lsy.wordcheck.unit.business.controller

import com.lsy.wordcheck.controller.ApiControllerAdvice
import com.lsy.wordcheck.controller.ValidatePasswordController
import com.lsy.wordcheck.dto.PasswordDto
import com.lsy.wordcheck.dto.ValidDto
import com.lsy.wordcheck.service.ValidatePasswordService
import com.lsy.wordcheck.utils.JsonUtils
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultHandlers
import org.springframework.test.web.servlet.result.MockMvcResultMatchers
import org.springframework.test.web.servlet.setup.MockMvcBuilders

@ExtendWith(MockitoExtension::class)
class ValidatePasswordControllerTest {

    private val POST_VALIDATE_PASSWORD_ENDPOINT: String =
        ValidatePasswordController.BASE_ENDPOINT
        .plus(ValidatePasswordController.POST_VALIDATE_PASSWORD)
    private var mockMvc: MockMvc? = null

    @Mock
    private val service: ValidatePasswordService? = null

    @InjectMocks
    private val controller: ValidatePasswordController? = null

    @BeforeEach
    fun setup() {
        mockMvc = MockMvcBuilders
            .standaloneSetup(controller)
            .setControllerAdvice(ApiControllerAdvice())
            .build()
    }

    @Test
    @Throws(Exception::class)
    fun okWhenPassWordIsValid() {
        val request = PasswordDto("test")
        mockValid(true)
        postValidatePassword(request)
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value("true"))
    }

    @Test
    @Throws(Exception::class)
    fun badRequestWhenPasswordIsInvalid() {
        val request = PasswordDto("test")
        mockValid(false)
        postValidatePassword(request)
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value("false"))
    }

    @Test
    @Throws(Exception::class)
    fun badRequestWhenMalformedRequestBody() {
        postValidatePasswordPayload("test")
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.errors.message").value("Malformed request body"))
    }

    @Test
    @Throws(Exception::class)
    fun badRequestWhenPasswordIsEmpty() {
        mockValid(false)
        postValidatePassword(PasswordDto(""))
            .andDo(MockMvcResultHandlers.print())
            .andExpect(MockMvcResultMatchers.status().isBadRequest)
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").exists())
            .andExpect(MockMvcResultMatchers.jsonPath("$.valid").value("false"))
    }

    private fun mockValid(valid: Boolean) {
        Mockito.`when`<Any>(service!!.isValid(ArgumentMatchers.anyString())).thenReturn(valid)
    }

    @Throws(Exception::class)
    private fun postValidatePassword(request: PasswordDto): ResultActions {
        return postValidatePasswordPayload(JsonUtils.toString(request))
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
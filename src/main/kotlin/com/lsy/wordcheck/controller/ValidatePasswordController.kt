package com.lsy.wordcheck.controller

import com.lsy.wordcheck.dto.PasswordDto
import com.lsy.wordcheck.dto.ValidDto
import com.lsy.wordcheck.service.ValidatePasswordService
import com.lsy.wordcheck.transformer.toValidDto
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping(ValidatePasswordController.BASE_ENDPOINT)
class ValidatePasswordController internal constructor(
    private val service: ValidatePasswordService
) : BaseController() {

    companion object {
        const val BASE_ENDPOINT = "/validate"
        const val POST_VALIDATE_PASSWORD = "/password"
    }

    @PostMapping(POST_VALIDATE_PASSWORD)
    fun validatePassword(@RequestBody request:@Valid PasswordDto?): ResponseEntity<ValidDto> {
        return buildPostResponse(
            service.isValid(request!!.password)
        )
    }

    private fun buildPostResponse(success: Boolean): ResponseEntity<ValidDto> {
        return buildPostResponse(success, success.toValidDto())
    }

}
package com.lsy.wordcheck.integration.service

import com.lsy.wordcheck.service.ValidatePasswordService
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ValidatePasswordServiceTest {

    @Autowired
    private val service: ValidatePasswordService? = null

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["AbTp9!fok", "AbTp9!fok2"])
    fun whenPassIsValid(pass: String) {
        assertTrue(service!!.isValid(pass))
    }

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(strings = ["", "aa", "ab", "AAAbbbCc", "AbTp9!foo", "AbTp9!foA", "AbTp9 fok"])
    fun whenPassIsNotValid(pass: String) {
        assertFalse(service!!.isValid(pass))
    }
}

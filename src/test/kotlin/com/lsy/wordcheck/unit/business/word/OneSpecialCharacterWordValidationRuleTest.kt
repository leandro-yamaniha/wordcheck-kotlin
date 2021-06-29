package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.OneSpecialCharacterWordValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OneSpecialCharacterWordValidationRuleTest {

    private val validationRule = OneSpecialCharacterWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["12345678L9!","7ABCD+EFGHI","1234&5x67890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["dsafafewrqrwe","A213dsfdsf","ASDfdsf;."])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))

}

package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.OneNumberCharacterWordValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OneNumberWordValidationRuleTest {

    private val validationRule = OneNumberCharacterWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["12345678L9","7ABCDEFGHI","12345x67890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["dsafafewrqrwe","+-()**dsfdsf","???ASDfdsf"])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))

}

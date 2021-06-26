package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.OneLetterUpperCaseWordValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OneLetterUpperCaseWordValidationRuleTest {

    private val validationRule = OneLetterUpperCaseWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["12345678L9","gABCDEFGHI","12345x67890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["1234567891","dsafafewrqrwe","1234567890dsfdsf","1+34567890asd+1fdsf"])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))

}
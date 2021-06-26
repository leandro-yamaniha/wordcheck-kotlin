package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.OneLetterLowerCaseWordValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class OneLetterLowerCaseWordValidationRuleTest {

    private val validationRule = OneLetterLowerCaseWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["123456789l","gABCDEFGHI","12345x67890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["1234567891","AABCDEFGHI","1234567890ABC1DEF","1+34567890AB+1DEF"])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))

}
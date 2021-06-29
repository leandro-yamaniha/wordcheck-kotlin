package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.MinNineCharacterWordValidationRule
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class MinNineCharacterWordValidationRuleTest {

    private val validationRule = MinNineCharacterWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["123456789","ABCDEFGHI","1234567890ABCDEF"])
    fun whenIsValid(word:String) = assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["","1","AB","123","abcd","456789","aBcdef"," aBcdef"])
    fun whenIsInvalid(word:String) = assertFalse(validationRule.isValid(word))

}

package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.NoEmptyCharacterWordValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NoEmptyCharacterWordValidationRuleTest {

    private val validationRule = NoEmptyCharacterWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["123456789","ABCDEFGHI","1234567890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = [" ","A B","12 3","a bcd","45678 9","aBcdef "," aBcdef"])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))
}

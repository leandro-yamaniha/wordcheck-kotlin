package com.lsy.wordcheck.unit.business.character

import com.lsy.wordcheck.businness.rules.character.impl.NumberCharacterValidationRule
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class NumberCharacterValidationRuleTest {

    private val validationRule = NumberCharacterValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(chars = ['0','1','2','3','4','5','6','7','8','9'])
    fun whenIsValid(character:Char) = assertTrue(validationRule.isValid(character))

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = ['a','b','O','C','D','E','f','g','h','I','J','K','L','n','.',';','=','t','u','v','x','w','z',' '])
    fun whenIsInValid(character:Char) = assertFalse(validationRule.isValid(character))

}
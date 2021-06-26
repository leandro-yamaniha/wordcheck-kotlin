package com.lsy.wordcheck.unit.business.character

import com.lsy.wordcheck.businness.rules.character.impl.UpperCaseCharacterValidationRule
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class UpperCaseCharacterValidationRuleTest {

    private val validationRule = UpperCaseCharacterValidationRule()

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'X', 'W', 'Y', 'Z'])
    fun whenIsValid(character: Char?) = assertTrue(validationRule.isValid(character!!))

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = ['a','b','0','1','2','3','4','5','6','7','8','9','0','n','.',';','=','t','u','v','x','w','z',' '])
    fun whenIsInvalid(character: Char?) = assertFalse(validationRule.isValid(character!!))

}
package com.lsy.wordcheck.unit.business.character

import com.lsy.wordcheck.businness.rules.character.impl.NumberCharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.SpecialCharacterValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SpecialCharacterValidationRuleTest {

    private val validationRule = SpecialCharacterValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(chars = ['!','@','#','$','%','^','&','*','(',')','-','+'])
    fun whenIsValid(character:Char) = Assertions.assertTrue(validationRule.isValid(character))

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = ['a','b','0','C','D','E','f','g','h','I','J','K','L','n','0','2','3','t','u','v','x','w','z',' '])
    fun whenIsInValid(character:Char) = Assertions.assertFalse(validationRule.isValid(character))

}
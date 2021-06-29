package com.lsy.wordcheck.unit.business.character

import com.lsy.wordcheck.businness.rules.character.impl.LowerCaseCharacterValidationRule
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LowerCaseCharacterValidationRuleTest {

    private val validationRule = LowerCaseCharacterValidationRule()

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = [
        'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o',
        'p', 'q', 'r', 's', 't', 'x', 'w', 'y', 'z'])
    fun whenIsValid(character: Char?) = assertTrue(validationRule.isValid(character!!))

    @ParameterizedTest(name = "{0} is not valid")
    @ValueSource(chars = [
        'A', 'B', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0', 'N', '.',
        ';', '=', 'R', 'S', 'T', 'X', 'W', 'Y', ' '])
    fun whenIsInvalid(character: Char?) = assertFalse(validationRule.isValid(character!!))

}

package com.lsy.wordcheck.unit.business.word

import com.lsy.wordcheck.businness.rules.word.impl.NoRepeatCharacterWordValidationRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NoRepeatCharacterWordValidationRuleTest {

    private val validationRule = NoRepeatCharacterWordValidationRule()

    @ParameterizedTest(name = "{0} is valid")
    @ValueSource(strings = ["123456789","ABCDEFGHI","1234567890ABCDEF"])
    fun whenIsValid(word:String) = Assertions.assertTrue(validationRule.isValid(word))

    @ParameterizedTest(name = "{0} is invalid")
    @ValueSource(strings = ["1234567891","AABCDEFGHI","1234567890ABC1DEF","1+34567890AB+1DEF"])
    fun whenIsInvalid(word:String) = Assertions.assertFalse(validationRule.isValid(word))

}

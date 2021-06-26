package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.SpecialCharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.UpperCaseCharacterValidationRule
import com.lsy.wordcheck.businness.rules.word.template.QuantityRepeatCharacterWordValidationRule

class OneSpecialCharacterWordValidationRule: QuantityRepeatCharacterWordValidationRule() {
    override fun characterValidationRule(): CharacterValidationRule = SpecialCharacterValidationRule()
    override fun repeat()=1
}
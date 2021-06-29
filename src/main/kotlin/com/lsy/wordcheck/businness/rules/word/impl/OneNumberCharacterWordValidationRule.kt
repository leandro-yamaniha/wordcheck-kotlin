package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.NumberCharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.UpperCaseCharacterValidationRule
import com.lsy.wordcheck.businness.rules.word.template.QuantityRepeatCharacterWordValidationRule

class OneNumberCharacterWordValidationRule: QuantityRepeatCharacterWordValidationRule() {
    override fun characterValidationRule(): CharacterValidationRule = NumberCharacterValidationRule()
    override fun repeat()=1
}

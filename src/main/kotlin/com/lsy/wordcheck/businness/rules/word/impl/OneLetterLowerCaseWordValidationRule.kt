package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule
import com.lsy.wordcheck.businness.rules.character.impl.LowerCaseCharacterValidationRule
import com.lsy.wordcheck.businness.rules.word.template.QuantityRepeatCharacterWordValidationRule

class OneLetterLowerCaseWordValidationRule: QuantityRepeatCharacterWordValidationRule() {

    override fun characterValidationRule(): CharacterValidationRule = LowerCaseCharacterValidationRule()
    override fun repeat()=1
}
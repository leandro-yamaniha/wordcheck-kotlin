package com.lsy.wordcheck.businness.rules.character.impl

import com.lsy.wordcheck.businness.rules.character.template.SequenceCharacterValidationRule

class LowerCaseCharacterValidationRule: SequenceCharacterValidationRule() {
    override fun beginChar(): Char= 'a'
    override fun endChar(): Char ='z'
}

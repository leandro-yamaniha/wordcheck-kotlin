package com.lsy.wordcheck.businness.rules.character.impl

import com.lsy.wordcheck.businness.rules.character.template.SequenceCharacterValidationRule

class NumberCharacterValidationRule: SequenceCharacterValidationRule() {
    override fun beginChar(): Char= '0'
    override fun endChar(): Char ='9'
}
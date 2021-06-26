package com.lsy.wordcheck.businness.rules.character.impl

import com.lsy.wordcheck.businness.rules.character.template.SequenceCharacterValidationRule

class UpperCaseCharacterValidationRule:SequenceCharacterValidationRule() {
    override fun beginChar(): Char= 'A'
    override fun endChar(): Char ='Z'
}
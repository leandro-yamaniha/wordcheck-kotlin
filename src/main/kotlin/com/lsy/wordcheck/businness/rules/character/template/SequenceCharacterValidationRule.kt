package com.lsy.wordcheck.businness.rules.character.template

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule

abstract class SequenceCharacterValidationRule : CharacterValidationRule {

    abstract fun beginChar():Char
    abstract fun endChar():Char

    override fun isValid(character: Char): Boolean =
         (character.code>=beginChar().code && character.code <= endChar().code)

}
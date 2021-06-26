package com.lsy.wordcheck.businness.rules.character

interface CharacterValidationRule {

    fun isValid(character:Char):Boolean

}
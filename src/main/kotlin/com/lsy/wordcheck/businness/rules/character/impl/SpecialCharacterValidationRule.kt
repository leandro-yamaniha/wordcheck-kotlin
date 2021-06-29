package com.lsy.wordcheck.businness.rules.character.impl

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule

class SpecialCharacterValidationRule: CharacterValidationRule {
    override fun isValid(character: Char): Boolean {
        for (specialCharacter in "!@#$%^&*()-+".toCharArray()){
            if (specialCharacter == character){
                return true
            }
        }
        return false
    }
}

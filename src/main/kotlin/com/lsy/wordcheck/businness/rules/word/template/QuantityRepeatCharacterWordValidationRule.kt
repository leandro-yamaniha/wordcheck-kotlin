package com.lsy.wordcheck.businness.rules.word.template

import com.lsy.wordcheck.businness.rules.character.CharacterValidationRule
import com.lsy.wordcheck.businness.rules.word.WordValidationRule

abstract class QuantityRepeatCharacterWordValidationRule: WordValidationRule {

    abstract fun characterValidationRule(): CharacterValidationRule
    abstract fun repeat():Int

    override fun isValid(word: String):Boolean {
        var quantityFound =0;
        for (character in word.toCharArray()){
            if (characterValidationRule().isValid(character)){
                quantityFound++
            }
            if (quantityFound == repeat()){
                return true
            }
        }
        return false
    }
}
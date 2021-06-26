package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule

class NoEmptyCharacterWordValidationRule:WordValidationRule {
    override fun isValid(word: String): Boolean {
        for(character in word.toCharArray()){
            if (character.code==32){
                return false;
            }
        }
        return true;
    }
}
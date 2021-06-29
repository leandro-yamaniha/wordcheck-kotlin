package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule

class NoEmptyCharacterWordValidationRule:WordValidationRule {
    companion object {
        private const val SPACE = 32
    }

    override fun isValid(word: String): Boolean {
        for(character in word.toCharArray()){
            if (character.code==SPACE){
                return false;
            }
        }
        return true;
    }
}

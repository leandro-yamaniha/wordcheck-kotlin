package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule

class NoRepeatCharacterWordValidationRule: WordValidationRule {
    override fun isValid(word: String): Boolean {
        val chars = word.toCharArray();
        for (indexChar1 in chars.indices){
            for (indexChar2 in chars.indices){
                if (indexChar1!=indexChar2 && chars[indexChar1] == chars[indexChar2]){
                    return false;
                }
            }
        }
        return true;
    }
}

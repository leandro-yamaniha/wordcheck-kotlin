package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule

class MinNineCharacterWordValidationRule:WordValidationRule {
    companion object{
        const val MAXLENGTH = 9
    }

    override fun isValid(word: String): Boolean= word.length >=MAXLENGTH
}

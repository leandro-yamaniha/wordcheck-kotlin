package com.lsy.wordcheck.businness.rules.word.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule

class MinNineCharacterWordValidationRule:WordValidationRule {
    override fun isValid(word: String): Boolean= word.length >=9
}
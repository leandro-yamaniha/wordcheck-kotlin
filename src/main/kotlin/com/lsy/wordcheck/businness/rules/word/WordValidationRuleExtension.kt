package com.lsy.wordcheck.businness.rules.word

import com.lsy.wordcheck.businness.rules.word.exception.InvalidWordValidationException

fun WordValidationRule.validate(word:String) {
    if (!this.isValid(word)){
        throw InvalidWordValidationException();
    }
}
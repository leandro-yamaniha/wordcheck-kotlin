package com.lsy.wordcheck.businness.rules.word

interface WordValidationRule {
    fun isValid(word:String):Boolean
}

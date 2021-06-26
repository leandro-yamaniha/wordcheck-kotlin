package com.lsy.wordcheck.service

interface ValidatePasswordService {
    fun isValid(word:String):Boolean
}

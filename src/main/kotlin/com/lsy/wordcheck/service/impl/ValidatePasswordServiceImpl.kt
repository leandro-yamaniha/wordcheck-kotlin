package com.lsy.wordcheck.service.impl

import com.lsy.wordcheck.businness.rules.word.WordValidationRule
import com.lsy.wordcheck.businness.rules.word.exception.InvalidWordValidationException
import com.lsy.wordcheck.businness.rules.word.impl.*
import com.lsy.wordcheck.businness.rules.word.validate
import com.lsy.wordcheck.service.ValidatePasswordService
import org.springframework.stereotype.Service
import javax.annotation.PostConstruct

@Service
public class ValidatePasswordServiceImpl:ValidatePasswordService {

    val validationRules = ArrayList<WordValidationRule>();

    @PostConstruct
    fun initRules(){
        validationRules.add(MinNineCharacterWordValidationRule())
        validationRules.add(OneNumberCharacterWordValidationRule())
        validationRules.add(OneLetterLowerCaseWordValidationRule())
        validationRules.add(OneLetterUpperCaseWordValidationRule())
        validationRules.add(OneSpecialCharacterWordValidationRule())
        validationRules.add(NoRepeatCharacterWordValidationRule())
        validationRules.add(NoEmptyCharacterWordValidationRule())
    }

    override fun isValid(word: String): Boolean {
        return try{
            for (validationRule in validationRules){
                validationRule.validate(word)
            }
            true
        } catch(e: InvalidWordValidationException){
            false
        }
    }

}
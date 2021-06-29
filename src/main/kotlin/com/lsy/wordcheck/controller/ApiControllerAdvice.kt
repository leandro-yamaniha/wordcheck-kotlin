package com.lsy.wordcheck.controller

import com.lsy.wordcheck.dto.ErrorDto
import org.springframework.http.HttpStatus
import org.springframework.http.converter.HttpMessageNotReadableException
import org.springframework.validation.FieldError
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus


import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiControllerAdvice {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidationExceptions(exception:MethodArgumentNotValidException): ErrorDto {
        val errors: MutableMap<String, String?> = HashMap()
        for (error in exception.bindingResult.allErrors){
            val fieldName = (error as FieldError).field
            val errorMessage = error.defaultMessage
            errors.put(fieldName,errorMessage)
        }
        return ErrorDto(errors);
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException::class)
    fun handleHttpMessageNotReadableException(): ErrorDto {
        val errors: MutableMap<String, String?> = HashMap()
        errors.put("message","Malformed request body")
        return ErrorDto(errors)
    }

}

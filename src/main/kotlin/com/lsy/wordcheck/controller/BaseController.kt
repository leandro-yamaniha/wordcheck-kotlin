package com.lsy.wordcheck.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

abstract class BaseController {
    internal fun <T>  buildPostResponse(success:Boolean, body:T):ResponseEntity<T> {
        val httpStatus = if(success) HttpStatus.OK else HttpStatus.BAD_REQUEST;
        return ResponseEntity.status(httpStatus).body(body);
    }
}
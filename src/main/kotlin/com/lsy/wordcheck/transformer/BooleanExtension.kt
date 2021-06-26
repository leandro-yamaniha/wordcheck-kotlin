package com.lsy.wordcheck.transformer

import com.lsy.wordcheck.dto.ValidDto

fun Boolean.toValidDto() = ValidDto(valid = this)

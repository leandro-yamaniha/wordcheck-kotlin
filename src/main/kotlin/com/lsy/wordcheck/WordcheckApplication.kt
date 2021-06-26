package com.lsy.wordcheck

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class WordcheckApplication

fun main(args: Array<String>) {
	runApplication<WordcheckApplication>(*args)
}

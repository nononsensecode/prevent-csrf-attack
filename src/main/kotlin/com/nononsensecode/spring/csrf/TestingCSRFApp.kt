package com.nononsensecode.spring.csrf

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TestingCSRFApp

fun main(args: Array<String>) {
    runApplication<TestingCSRFApp>(*args)
}
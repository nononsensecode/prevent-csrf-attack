package com.nononsensecode.spring.csrf.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class HelloController {
    @GetMapping("/hello-world")
    fun getHelloWorld(): String {
        return "hello-world"
    }

    @GetMapping("another-hello-world")
    fun anotherHello(): String {
        return "another-hello"
    }
}
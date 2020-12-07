package com.nononsensecode.spring.csrf.controller

import mu.KotlinLogging
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam

private val logger = KotlinLogging.logger {  }

@Controller
class BankController {
    @GetMapping("/transfer-page")
    fun getTransferPage(): String {
        return "transfer-page"
    }

    @PostMapping("/transfer")
    fun transfer(@RequestParam("accountNo") accountNumber: Int,
                 @RequestParam("amount") amount: Int, model: Model): String {
        val transferred = "Transfer $amount to $accountNumber"
        logger.info { transferred }
        model.addAttribute("log", transferred)
        return "transferred"
    }

    @GetMapping("/transfer2")
    fun transferWithGet(@RequestParam("accountNo") accountNumber: Int,
                 @RequestParam("amount") amount: Int,
                        model: Model): String {
        val transferred = "Transfer $amount to $accountNumber"
        logger.info { transferred }
        model.addAttribute("log", transferred)
        return "transferred"

    }
}
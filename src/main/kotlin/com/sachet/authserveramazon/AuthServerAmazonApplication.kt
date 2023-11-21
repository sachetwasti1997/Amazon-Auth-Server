package com.sachet.authserveramazon

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [SecurityAutoConfiguration::class])
class AuthServerAmazonApplication

fun main(args: Array<String>) {
	runApplication<AuthServerAmazonApplication>(*args)
}

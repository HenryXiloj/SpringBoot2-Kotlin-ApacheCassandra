package com.henry

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SpringBootCassandraKotlinApplication

fun main(args: Array<String>) {
	runApplication<SpringBootCassandraKotlinApplication>(*args)
}

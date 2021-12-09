package com.rapipay.kotlinexample

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@EnableMongoRepositories("com.rapipay.kotlinexample.repository")
class KotlinexampleApplication

fun main(args: Array<String>) {
	runApplication<KotlinexampleApplication>(*args)
}

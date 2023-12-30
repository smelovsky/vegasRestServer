package com.rhonda.vegasrestserver

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class VegasRestServerApplication

fun main(args: Array<String>) {
	runApplication<VegasRestServerApplication>(*args)
}

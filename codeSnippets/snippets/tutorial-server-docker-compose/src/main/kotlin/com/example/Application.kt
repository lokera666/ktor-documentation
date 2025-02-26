package com.example

import com.example.plugins.*
import io.ktor.server.application.*
import com.example.model.PostgresTaskRepository

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val repository = PostgresTaskRepository()

    configureSerialization(repository)
    configureDatabases(environment.config)
    configureRouting()
}
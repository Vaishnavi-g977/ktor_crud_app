package com.example

import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import io.github.cdimascio.dotenv.Dotenv


fun Application.configureDatabases() {
    val dotenv = Dotenv.load()
    Database.connect(
        "jdbc:postgresql://localhost:5432/connection",
        user = dotenv["DB_USERNAME"] ?: error("DB_USERNAME not found in .env file"),
        password = dotenv["DB_PASSWORD"] ?: error("DB_PASSWORD not found in .env file")
    )
}

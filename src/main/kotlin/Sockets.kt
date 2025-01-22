package com.example

import io.ktor.websocket.*
import io.ktor.server.application.*
import io.ktor.serialization.*
import com.example.model.*
import kotlinx.serialization.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.websocket.*
import io.ktor.websocket.*
import kotlinx.serialization.json.Json
import io.ktor.serialization.kotlinx.*
import java.time.Duration
import io.ktor.server.response.*
import io.ktor.server.routing.*
import kotlinx.coroutines.*
import kotlin.time.toKotlinDuration // Import this extension function

fun Application.configureSockets() {
    install(WebSockets) {
        contentConverter = KotlinxWebsocketSerializationConverter(Json)
        pingPeriod = Duration.ofSeconds(15) // Convert to kotlin.time.Duration
        timeout = Duration.ofSeconds(15)   // Convert to kotlin.time.Duration
        maxFrameSize = Long.MAX_VALUE
        masking = false
    }

    routing {
        webSocket("/tasks") {
            val tasks = listOf(
                Task("cleaning", "Clean the house", Priority.Low),
                Task("gardening", "Mow the lawn", Priority.Medium),
                Task("shopping", "Buy the groceries", Priority.High),
                Task("painting", "Paint the fence", Priority.Medium)
            )

            for (task in tasks) {
                sendSerialized(task)
                delay(1000)
            }

            close(CloseReason(CloseReason.Codes.NORMAL, "All done"))
        }
    }
}

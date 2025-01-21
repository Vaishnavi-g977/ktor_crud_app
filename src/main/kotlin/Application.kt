//
//package com.example
//import com.example.model.*
//import io.ktor.server.application.*
//
//fun main(args: Array<String>) {
//    io.ktor.server.netty.EngineMain.main(args)
//}
//
//fun Application.module() {
//    val repository = PostgresTaskRepository()
//    configureSerialization(repository)
//    configureDatabases()
//    configureRouting()
//}
package com.example

import com.example.di.* // Import the Dagger AppComponent
import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import com.example.model.PostgresTaskRepository
fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val appComponent = DaggerAppComponent.create()
//    appComponent.inject(this)

    val repository: PostgresTaskRepository = appComponent.postgresTaskRepository()

    configureSerialization(repository)
    configureDatabases()
    configureRouting()
}

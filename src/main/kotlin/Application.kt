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
    // Create the Dagger component
    val appComponent = DaggerAppComponent.create()

    // Inject dependencies into the Application (if needed)
//    appComponent.inject(this)

    // Get the repository instance from the Dagger component
    val repository: PostgresTaskRepository = appComponent.postgresTaskRepository()

    // Configure the Ktor server
    configureSerialization(repository) // Configure JSON serialization with the repository
    configureDatabases()               // Configure the database setup
    configureRouting()       // Configure the routing with the repository
}

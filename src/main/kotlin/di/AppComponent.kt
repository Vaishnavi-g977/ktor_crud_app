package com.example.di
import io.ktor.server.application.*
import dagger.Component
import javax.inject.Singleton
import com.example.model.*
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
    // Inject dependencies into Ktor's Application class
//    fun inject(application: Application)
    fun postgresTaskRepository(): PostgresTaskRepository

    // Inject into other classes if needed
//    fun inject(repository: TaskRepository)
}

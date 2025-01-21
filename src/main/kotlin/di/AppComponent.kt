package com.example.di
import io.ktor.server.application.*
import dagger.Component
import javax.inject.Singleton
import com.example.model.*
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
//    fun inject(application: Application)
    fun postgresTaskRepository(): PostgresTaskRepository
//    fun inject(repository: TaskRepository)
}

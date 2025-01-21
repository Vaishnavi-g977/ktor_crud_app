package com.example.di

import com.example.model.PostgresTaskRepository
import com.example.model.TaskRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    // Provide the PostgresTaskRepository instance
    @Provides
    @Singleton
    fun providePostgresTaskRepository(): PostgresTaskRepository {
        return PostgresTaskRepository()  // Create and return an instance of PostgresTaskRepository
    }
}

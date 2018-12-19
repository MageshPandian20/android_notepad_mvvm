package com.example.esamohammed.mvvm.di

import com.example.esamohammed.mvvm.repository.BaseRepository
import com.example.esamohammed.mvvm.repository.database.AppDatabase
import com.example.esamohammed.mvvm.util.CodeSnippet
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(injectorHelper: AppController)
    fun inject(baseRepository: BaseRepository)
    fun inject(baseRepository: CodeSnippet)
    fun inject(baseRepository: AppDatabase)
}

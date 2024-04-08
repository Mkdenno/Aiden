package com.example.aiden.di

import com.example.aiden.data.AidenApi
import com.example.aiden.repository.AidenRepository
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import retrofit2.create

interface AppModule{
    val api:AidenApi
    val aidenRepository: AidenRepository
}

class AppModuleImpl : AppModule{
    override val api: AidenApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://bible-api.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create()

    }
    override val aidenRepository: AidenRepository by lazy {
        AidenRepository.AidenRepositoryImpl(api)
    }

}
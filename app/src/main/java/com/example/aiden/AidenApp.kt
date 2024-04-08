package com.example.aiden

import android.app.Application
import com.example.aiden.di.AppModule
import com.example.aiden.di.AppModuleImpl

class AidenApp : Application() {

    companion object{
        lateinit var appModule: AppModule
    }

    override fun onCreate() {
        super.onCreate()

        appModule=AppModuleImpl()
    }


}
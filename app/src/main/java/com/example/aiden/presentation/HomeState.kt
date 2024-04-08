package com.example.aiden.presentation

import com.example.aiden.models.AidenResponse

class HomeState (
    val isLoading:Boolean=false,
    val data: AidenResponse?=null,
    val errorMessage:String=""

)
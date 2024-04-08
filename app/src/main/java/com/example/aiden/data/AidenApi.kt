package com.example.aiden.data

import com.example.aiden.models.AidenResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AidenApi {

    @GET()
    suspend fun getBibleVerses(@Query("random") type: String
    ): AidenResponse

}
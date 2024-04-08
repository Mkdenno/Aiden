package com.example.aiden.repository

import com.example.aiden.data.AidenApi
import com.example.aiden.models.AidenResponse
import com.example.aiden.models.Verse
import com.example.aiden.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

interface AidenRepository{
    fun getAidenVerse(verse: String) : Flow<Resource<AidenResponse>>

    class AidenRepositoryImpl(
        private val api: AidenApi
    ):AidenRepository{
        override fun getAidenVerse(verse: String): Flow<Resource<AidenResponse>> = flow {
        try {
            emit(Resource.Loading())
             val verseList=api.getBibleVerses(verse)
            emit(Resource.Success(verseList))
        }catch (e: Exception){
            emit(Resource.Error("Somethin went wrong"))
        }catch (e:IOException){
            emit(Resource.Error("Network error"))
        }
            catch (e: HttpException){
                emit(Resource.Error("ServerError"))

            }

        }

    }

}
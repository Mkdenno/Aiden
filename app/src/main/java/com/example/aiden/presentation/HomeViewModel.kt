package com.example.aiden.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.aiden.models.Verse
import com.example.aiden.repository.AidenRepository
import com.example.aiden.util.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel(
    private val aidenRepository: AidenRepository
):ViewModel(){

    private val _state= MutableStateFlow(HomeState())
    val state=_state.asStateFlow()

    init {
        getBibleVerse("verse")
    }


    fun getBibleVerse(verse: String)=viewModelScope.launch {
        aidenRepository.getAidenVerse(verse).collect(){result->

            when(result){
                is Resource.Error->{
                    _state.value= HomeState(
                        isLoading = false,
                        errorMessage = result.message

                    )

                }
                is Resource.Loading->{
                    _state.value= HomeState(
                        isLoading = true
                    )

                }
                is Resource.Success->{

                    Log.i("Response", result.data.toString())
                    _state.value=HomeState(
                        isLoading = false,
                        data = result.data

                    )
                }
            }


    }

    }

}

fun <VM: ViewModel> viewModelFactoryHelper(initializer: () -> VM): ViewModelProvider.Factory {
    return object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return initializer() as T
        }
    }}
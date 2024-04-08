package com.example.aiden.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.FlowRowScopeInstance.align
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.aiden.models.AidenResponse

@Composable
fun homeScreen(
    viewModel: HomeViewModel
) {

    val state by viewModel.state.collectAsState()
    val context= LocalContext.current

    if (state.isLoading){

        CircularProgressIndicator()
    }
    if (state.errorMessage.isNotEmpty()){
        Toast.makeText(
            context,
            "",
            Toast.LENGTH_SHORT
        ).show()

    }
    
    Box(
        modifier = Modifier.fillMaxWidth()

    ){


    }
    
}

@Composable
fun getBibleITem(
    aidenResponse: AidenResponse
) {
    Box (
        modifier = Modifier
            .size(200.dp)
            .background(
                shape = RoundedCornerShape(12.dp),
                color = MaterialTheme.colorScheme.background
            )

    ){
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color.Transparent,
                            Color.Black.copy(1f),
                            Color.Black.copy(1f),
                            Color.Black.copy(1f)
                        )
                    )
                ),
            contentAlignment = Alignment.Center


        ){
            Text(text =aidenResponse.text )
            Text(text =aidenResponse.translation_id )
            Text(text =aidenResponse.translation_name )
            Text(text =aidenResponse.translation_note )
        }

    }



}
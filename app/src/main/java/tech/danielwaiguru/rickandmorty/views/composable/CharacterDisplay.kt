package tech.danielwaiguru.rickandmorty.views.composable

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import tech.danielwaiguru.rickandmorty.views.character_list.CharacterViewModel
import timber.log.Timber


@Composable
fun DisplayCharacters(
    navController: NavController, characterViewModel: CharacterViewModel = hiltNavGraphViewModel()
) {
    val mortiesList by remember {
        characterViewModel.morties
    }
    val errorMessage by remember {
        characterViewModel.onError
    }
    val isLoading by remember {
        characterViewModel.isLoading
    }
    Timber.d(mortiesList.toString())
    LazyColumn(contentPadding = PaddingValues(12.dp)) {
        val itemCount = if (mortiesList.size % 2 == 0) {
            mortiesList.size / 2
        } else {
            mortiesList.size / 2 + 1
        }
        items(itemCount) {
            CharacterRow(rowIndex = it, characters = mortiesList, navController = navController)
        }
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        if (isLoading) {
            CircularProgressIndicator(
                modifier = Modifier.scale(1f)
            )
        }
        if (errorMessage.isNotEmpty()){
            ShowError {
                characterViewModel.getAllCharacters()
            }
        }
    }
}
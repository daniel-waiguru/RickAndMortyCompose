package tech.danielwaiguru.rickandmorty.views.character_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltNavGraphViewModel
import androidx.navigation.NavController
import tech.danielwaiguru.rickandmorty.R
import tech.danielwaiguru.rickandmorty.views.composable.DisplayCharacters
import tech.danielwaiguru.rickandmorty.views.composable.SearchMenuBar
import tech.danielwaiguru.rickandmorty.views.composable.ShowError
import timber.log.Timber


@Composable
fun CharacterListScreen(navController: NavController,
                        characterViewModel: CharacterViewModel = hiltNavGraphViewModel()) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            Image(
                painter = painterResource(id = R.drawable.rick),
                contentDescription = stringResource(R.string.morty_logo),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .width(60.dp)
                    .align(CenterHorizontally)

            )
            SearchMenuBar(
                hint = stringResource(R.string.search_hint),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ){
                //Delegate the search Query to viewModel
            }
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
            DisplayCharacters(characters = mortiesList) {

            }
            Box(
                contentAlignment = Center
            ) {
                if (isLoading) {
                    CircularProgressIndicator()
                }
                if (errorMessage.isNotEmpty()){
                    ShowError(text = errorMessage) {
                        characterViewModel.getAllCharacters()
                    }
                }
            }
        }
    }
}
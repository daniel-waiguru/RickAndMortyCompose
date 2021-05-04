package tech.danielwaiguru.rickandmorty.ui.character_list

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import tech.danielwaiguru.rickandmorty.R
import tech.danielwaiguru.rickandmorty.ui.composable.SearchMenuBar

@Composable
fun CharacterListScreen(navController: NavController) {
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
        }
    }
}
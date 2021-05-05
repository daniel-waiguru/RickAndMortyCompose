package tech.danielwaiguru.rickandmorty

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import tech.danielwaiguru.rickandmorty.common.Constants
import tech.danielwaiguru.rickandmorty.views.character_list.CharacterListScreen
import tech.danielwaiguru.rickandmorty.ui.theme.RickAndMortyTheme
import tech.danielwaiguru.rickandmorty.views.navigation.Navigation

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RickAndMortyTheme {
                InitApp()
            }
        }
    }
}

@Composable
fun InitApp() {
    Navigation()
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RickAndMortyTheme {

    }
}
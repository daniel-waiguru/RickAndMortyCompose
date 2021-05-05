package tech.danielwaiguru.rickandmorty.views.navigation

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController
import tech.danielwaiguru.rickandmorty.common.Constants.CHARACTER_ID
import tech.danielwaiguru.rickandmorty.common.Constants.DOMINANT_COLOR
import tech.danielwaiguru.rickandmorty.views.character_list.CharacterListScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    //val viewModel: CharacterViewModel  = viewModel()
    NavHost(
        navController = navController,
        startDestination = "character_list_screen") {
        composable("character_list_screen") {
            CharacterListScreen(navController = navController)
        }
        composable(
            "character_details_screen/{DOMINANT_COLOR}/{CHARACTER_ID}",
            arguments = listOf(
                navArgument(DOMINANT_COLOR) {
                    type = NavType.IntType
                },
                navArgument(CHARACTER_ID) {
                    type = NavType.IntType
                }
            )
        ) { navBackStack ->
            val backgroundColor = remember {
                val color = navBackStack.arguments?.getInt(DOMINANT_COLOR)
                color?.let { Color(it) } ?: Color.White
            }
            val characterId = remember {
                navBackStack.arguments?.getInt(CHARACTER_ID)
            }
        }
    }
}
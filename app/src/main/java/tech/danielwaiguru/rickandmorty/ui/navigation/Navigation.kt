package tech.danielwaiguru.rickandmorty.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavArgument
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navArgument
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "characters") {
        composable("character_list_screen") {

        }
        composable(
            "character_details_screen",
            arguments = listOf(
                navArgument("color") {
                    type = NavType.IntType
                },
                navArgument("characterId") {
                    type = NavType.IntType
                }
            )
        ) {

        }
    }
}
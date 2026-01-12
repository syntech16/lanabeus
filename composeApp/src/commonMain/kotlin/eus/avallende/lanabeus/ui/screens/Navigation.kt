package eus.avallende.lanabeus.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Navigation(modifier: Modifier = Modifier) {
    val navController  = rememberNavController()
    NavHost(navController = navController, startDestination = "hasiera") {
        composable("hasiera") {
            HasieraScreen(
                navController,
                //onNavigateToZenbakiak = { navController.navigate("zenbakiak") },
                onNavigateToAditzak = { navController.navigate("aditzak") }
            )
        }
        composable("zenbakiak") {
            ZenbakiakScreen()
        }
        composable("aditzak") {
            //AditzakScreen() //TODO
        }
    }
}F
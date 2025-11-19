package za.co.betway.searchapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import za.co.betway.searchapp.presentation.ui.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    onExitApp: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {
        composable("splash") {
            SplashScreen(
                onExitApp = onExitApp,
                onNavigateHome = {
                    navController.navigate("home") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
    }
}
/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.ui.detail.DetailScreen
import za.co.betway.searchapp.presentation.ui.search.SearchScreen
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
                onNavigateSearch = {
                    navController.navigate("search") {
                        popUpTo("splash") { inclusive = true }
                    }
                }
            )
        }
        composable("search") {
            SearchScreen(
                onNavigateDetail = { id ->
                    navController.navigate("detail/$id")
                },
                onMenuClick = {
                    // TODO: hook up drawer or menu action
                }
            )
        }
        composable("detail/{id}") { backStackEntry ->
            val id = backStackEntry.arguments?.getString("id")?.toLongOrNull() ?: return@composable
            // TODO: fetch from repository
            val dummyQuestion = Question(id, "Title", "Body", 0, 0, 0, false, Author("User", null, ""), "", creationDate = 1558957289)
            DetailScreen(question = dummyQuestion)
        }
    }
}
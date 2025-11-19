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
                onNavigateDetail = { question ->
                    navController.navigateToDetail(question)
                },
                onMenuClick = {
                    // TODO: hook up drawer or menu action
                }
            )
        }
        composable("detail") { _ ->
            DetailScreen(question = navController.previousBackStackEntry?.savedStateHandle?.get<Question>(QUESTION_ARG_KEY) ?: return@composable)
        }
    }
}
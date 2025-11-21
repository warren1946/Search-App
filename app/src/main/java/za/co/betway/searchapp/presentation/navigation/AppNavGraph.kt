/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.navigation

import androidx.compose.material3.DrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import kotlinx.coroutines.launch
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.ui.detail.DetailScreen
import za.co.betway.searchapp.presentation.ui.history.HistoryScreen
import za.co.betway.searchapp.presentation.ui.search.SearchScreen
import za.co.betway.searchapp.presentation.ui.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    onExitApp: () -> Unit,
    drawerState: DrawerState
) {
    val scope = rememberCoroutineScope()

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
                    scope.launch { drawerState.open() }
                }
            )
        }
        composable("detail") { _ ->
            DetailScreen(
                question = navController.previousBackStackEntry
                    ?.savedStateHandle
                    ?.get<Question>(QUESTION_ARG_KEY)
                    ?: return@composable,
                onBackClick = { navController.popBackStack() }
            )
        }
        composable("history") {
            HistoryScreen(
                onBackClick = { navController.popBackStack() }
            )
        }
    }
}
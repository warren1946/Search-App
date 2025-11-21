/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui

import androidx.activity.compose.LocalActivity
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import za.co.betway.searchapp.presentation.ui.search.component.AppDrawer

@Composable
fun App() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val activity = LocalActivity.current

    AppDrawer(
        drawerState = drawerState,
        navController = navController,
        onExitApp = {
            activity?.finishAffinity()
        }
    )
}
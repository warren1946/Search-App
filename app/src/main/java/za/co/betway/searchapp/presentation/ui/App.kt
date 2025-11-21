/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui

import android.app.Activity
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.rememberNavController
import za.co.betway.searchapp.presentation.ui.search.component.AppDrawer

@Composable
fun App() {
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val activity = LocalContext.current as? Activity

    AppDrawer(
        drawerState = drawerState,
        navController = navController,
        onExitApp = {
            activity?.finishAffinity()
        }
    )
}
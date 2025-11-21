/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.search.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import kotlinx.coroutines.launch
import za.co.betway.searchapp.presentation.navigation.AppNavGraph
import za.co.betway.searchapp.presentation.theme.AppTypography

@Composable
fun AppDrawer(
    drawerState: DrawerState,
    navController: NavHostController,
    onExitApp: () -> Unit
) {
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(16.dp)
                ) {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.TopStart)
                    ) {
                        item {
                            Text(
                                text = "Menu",
                                style = AppTypography.titleMedium,
                                modifier = Modifier.padding(bottom = 16.dp)
                            )
                        }

                        item {
                            NavigationDrawerItem(
                                label = { Text("View History") },
                                selected = false,
                                onClick = {
                                    navController.navigate("history")
                                    scope.launch { drawerState.close() }
                                }
                            )
                        }
                    }
                    NavigationDrawerItem(
                        label = { Text("Exit App") },
                        selected = false,
                        onClick = { onExitApp() },
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .fillMaxWidth()
                    )
                }
            }
        }
    ) {
        AppNavGraph(
            navController = navController,
            onExitApp = onExitApp,
            drawerState = drawerState
        )
    }
}
/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.history

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import za.co.betway.searchapp.domain.mapper.toDomain
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.ui.search.component.SearchResultItem
import za.co.betway.searchapp.presentation.ui.shared.component.DetailTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HistoryScreen(navController: NavHostController, viewModel: HistoryViewModel = hiltViewModel()) {
    val items by viewModel.history.collectAsState()

    Scaffold(topBar = { DetailTopAppBar("Search History", onBackClick = { navController.popBackStack() }) }) { innerPadding ->
        if (items.isEmpty()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "No history yet.",
                    style = AppTypography.headlineSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
            }
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .navigationBarsPadding()
            ) {
                items(items) { qwa ->
                    SearchResultItem(
                        question = qwa.question.toDomain(answersCountOverride = qwa.answers.size),
                        modifier = Modifier
                            .clickable { navController.navigate("history_detail/${qwa.question.id}") }
                            .padding(vertical = 4.dp)
                    )
                    HorizontalDivider(thickness = 1.dp)
                }
            }
        }
    }
}
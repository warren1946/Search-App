/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.search

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import za.co.betway.searchapp.presentation.theme.surfaceDimDarkHighContrast
import za.co.betway.searchapp.presentation.ui.common.DefaultAppScreen
import za.co.betway.searchapp.presentation.ui.search.component.SearchResultItem
import za.co.betway.searchapp.presentation.ui.search.component.SearchTopAppBar

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    onNavigateDetail: (Long) -> Unit,
    onMenuClick: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()
    val query by viewModel.query.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        SearchTopAppBar(
            query = query,
            onQueryChange = { newQuery -> viewModel.updateQuery(newQuery) },
            onClearClick = { viewModel.updateQuery("") },
            onMenuClick = onMenuClick
        )

        when (uiState) {
            is SearchUiState.Idle -> DefaultAppScreen(message = "Start typing above to search StackOverflow.")
            is SearchUiState.Loading -> DefaultAppScreen(message = "Loading...", showProgress = true)
            is SearchUiState.Error -> DefaultAppScreen(message = (uiState as SearchUiState.Error).message)
            is SearchUiState.Success -> {
                val questions = (uiState as SearchUiState.Success).questions
                if (questions.isEmpty()) {
                    DefaultAppScreen(message = "No results found. Try another search.")
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .navigationBarsPadding()
                    ) {
                        items(questions) { question ->
                            Column {
                                SearchResultItem(
                                    question = question,
                                    modifier = Modifier
                                        .clickable { onNavigateDetail(question.id) }
                                        .padding(vertical = 4.dp)
                                )
                                HorizontalDivider(
                                    color = surfaceDimDarkHighContrast.copy(alpha = 0.2f),
                                    thickness = 1.dp
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
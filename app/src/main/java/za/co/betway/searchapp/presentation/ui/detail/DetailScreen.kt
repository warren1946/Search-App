/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.theme.surfaceContainerLowestLight
import za.co.betway.searchapp.presentation.ui.common.DefaultAppScreen
import za.co.betway.searchapp.presentation.ui.common.NoInternetDialog
import za.co.betway.searchapp.presentation.ui.detail.component.AnswerItem
import za.co.betway.searchapp.presentation.ui.detail.component.AnswersHeader
import za.co.betway.searchapp.presentation.ui.detail.component.AuthorSection
import za.co.betway.searchapp.presentation.ui.detail.component.DetailTopAppBar
import za.co.betway.searchapp.presentation.ui.detail.component.InformationHeader
import za.co.betway.searchapp.presentation.ui.detail.component.TagsRow
import za.co.betway.searchapp.presentation.utils.NetworkUtils

@Composable
fun DetailScreen(
    question: Question,
    onBackClick: () -> Unit,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    var selectedFilter by remember { mutableStateOf(AnswerFilter.Votes) }
    val context = LocalContext.current
    var showNoInternetDialog by remember { mutableStateOf(false) }

    if (showNoInternetDialog) {
        NoInternetDialog(onDismiss = { showNoInternetDialog = false })
    }

    LaunchedEffect(question) {
        if (NetworkUtils.hasInternetConnection(context)) {
            viewModel.loadAnswers(question.id)
        } else {
            showNoInternetDialog = true
        }

    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(surfaceContainerLowestLight),
        topBar = {
            DetailTopAppBar(onBackClick = onBackClick)
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .navigationBarsPadding()
        ) {
            item {
                InformationHeader(question)
                Spacer(Modifier.height(8.dp))
            }

            item {
                TagsRow(question.tags)
                Spacer(Modifier.height(8.dp))
            }

            item {
                AuthorSection(question)
                Spacer(Modifier.height(16.dp))
            }

            when (uiState) {
                is DetailUiState.Loading -> {
                    item {
                        DefaultAppScreen(message = "Loading answers...", showProgress = true)
                    }
                }

                is DetailUiState.Error -> {
                    item {
                        DefaultAppScreen(message = (uiState as DetailUiState.Error).message)
                    }
                }

                is DetailUiState.Success -> {
                    val answers = (uiState as DetailUiState.Success).answers
                    val sortedAnswers = when (selectedFilter) {
                        AnswerFilter.Active -> answers.sortedByDescending { it.creationDate }
                        AnswerFilter.Oldest -> answers.sortedBy { it.creationDate }
                        AnswerFilter.Votes -> answers.sortedByDescending { it.votes }
                    }

                    item {
                        AnswersHeader(
                            answerCount = answers.size,
                            selectedFilter = selectedFilter,
                            onFilterSelected = { selectedFilter = it }
                        )
                    }

                    itemsIndexed(sortedAnswers) { index, answer ->
                        AnswerItem(answer = answer)
                        if (answers.size > 1 && index < answers.lastIndex) {
                            HorizontalDivider(thickness = 1.dp)
                        }
                    }
                }
            }
        }
    }
}
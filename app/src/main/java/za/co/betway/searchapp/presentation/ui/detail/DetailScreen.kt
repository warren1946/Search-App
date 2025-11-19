/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import za.co.betway.searchapp.data.remote.mapper.formattedCreationDate
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.ui.common.DefaultAppScreen
import za.co.betway.searchapp.presentation.ui.common.HtmlText

@Composable
fun DetailScreen(
    question: Question,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(question) {
        viewModel.loadAnswers(question.id)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(question.title, style = AppTypography.titleLarge)
        Spacer(modifier = Modifier.height(8.dp))

        HtmlText(html = question.body)

        Spacer(modifier = Modifier.height(8.dp))
        Text(
            "Asked ${question.formattedCreationDate()} by ${question.author.name}",
            style = AppTypography.bodySmall
        )
        Text(
            "Votes: ${question.votes} | Views: ${question.views} | Answers: ${question.answersCount}",
            style = AppTypography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))
        Text("Answers", style = AppTypography.titleMedium)

        when (uiState) {
            is DetailUiState.Loading -> DefaultAppScreen(message = "Loading answers...", showProgress = true)
            is DetailUiState.Error -> DefaultAppScreen(message = (uiState as DetailUiState.Error).message)
            is DetailUiState.Success -> {
                val answers = (uiState as DetailUiState.Success).answers
                LazyColumn {
                    items(answers) { answer ->
                        Column(modifier = Modifier.padding(8.dp)) {
                            HtmlText(html = answer.body)
                            Text("Votes: ${answer.votes}", style = AppTypography.bodySmall)
                        }
                    }
                }
            }
        }
    }
}
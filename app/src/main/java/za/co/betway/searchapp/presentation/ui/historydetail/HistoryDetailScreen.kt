/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.historydetail

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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavHostController
import za.co.betway.searchapp.domain.mapper.toDomain
import za.co.betway.searchapp.presentation.ui.detail.component.AnswerItem
import za.co.betway.searchapp.presentation.ui.detail.component.AuthorSection
import za.co.betway.searchapp.presentation.ui.detail.component.InformationHeader
import za.co.betway.searchapp.presentation.ui.detail.component.TagsRow
import za.co.betway.searchapp.presentation.ui.shared.component.DefaultAppScreen
import za.co.betway.searchapp.presentation.ui.shared.component.DetailTopAppBar

@Composable
fun HistoryDetailScreen(
    questionId: Long,
    navController: NavHostController,
    viewModel: HistoryDetailViewModel = hiltViewModel()
) {
    val questionWithAnswers by viewModel.observe(questionId).collectAsState(initial = null)

    Scaffold(topBar = { DetailTopAppBar("More Info", onBackClick = { navController.popBackStack() }) }) { innerPadding ->
        val questionWithAnswersState = questionWithAnswers
        if (questionWithAnswersState == null) {
            DefaultAppScreen(message = "Loading...", showProgress = true)
        } else {
            val question = questionWithAnswersState.question.toDomain(answersCountOverride = questionWithAnswersState.answers.size)
            val answers = questionWithAnswersState.answers.map { it.toDomain() }

            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .navigationBarsPadding()
            ) {
                item { InformationHeader(question); Spacer(Modifier.height(8.dp)) }
                item { TagsRow(question.tags); Spacer(Modifier.height(8.dp)) }
                item {
                    AuthorSection(question); Spacer(Modifier.height(16.dp))
                    HorizontalDivider(thickness = 2.dp)
                }

                itemsIndexed(answers) { index, answer ->
                    AnswerItem(answer)
                    if (answers.size > 1 && index < answers.lastIndex) {
                        HorizontalDivider(thickness = 1.dp)
                    }
                }
            }
        }
    }
}
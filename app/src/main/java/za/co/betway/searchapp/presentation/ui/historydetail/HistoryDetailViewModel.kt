/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.historydetail

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import za.co.betway.searchapp.data.local.entity.QuestionWithAnswers
import za.co.betway.searchapp.data.repository.HistoryRepository
import javax.inject.Inject

@HiltViewModel
class HistoryDetailViewModel @Inject constructor(private val repository: HistoryRepository) : ViewModel() {
    fun observe(id: Long): Flow<QuestionWithAnswers?> = repository.getHistoryItem(id)
}
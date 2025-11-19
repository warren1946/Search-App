/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import za.co.betway.searchapp.domain.usecase.GetAnswersUseCase
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(private val getAnswersUseCase: GetAnswersUseCase) : ViewModel() {

    private val _uiState = MutableStateFlow<DetailUiState>(DetailUiState.Loading)
    val uiState: StateFlow<DetailUiState> = _uiState.asStateFlow()

    fun loadAnswers(questionId: Long) {
        viewModelScope.launch {
            _uiState.value = DetailUiState.Loading
            try {
                val answers = getAnswersUseCase(questionId)
                _uiState.value = DetailUiState.Success(answers)
            } catch (e: Exception) {
                _uiState.value = DetailUiState.Error("Failed to load answers")
            }
        }
    }
}
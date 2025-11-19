/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail

import za.co.betway.searchapp.domain.model.Answer

sealed class DetailUiState {
    object Loading : DetailUiState()
    data class Success(val answers: List<Answer>) : DetailUiState()
    data class Error(val message: String) : DetailUiState()
}
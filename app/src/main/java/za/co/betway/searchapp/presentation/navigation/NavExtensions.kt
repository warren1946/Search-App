/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.navigation

import androidx.navigation.NavController
import za.co.betway.searchapp.domain.model.Question

const val QUESTION_ARG_KEY = "question"

fun NavController.navigateToDetail(question: Question) {
    currentBackStackEntry?.savedStateHandle?.set(QUESTION_ARG_KEY, question)
    navigate("detail")
}
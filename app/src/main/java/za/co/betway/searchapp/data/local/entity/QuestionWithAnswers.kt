/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.local.entity

import androidx.room.Embedded
import androidx.room.Relation

data class QuestionWithAnswers(
    @Embedded val question: QuestionEntity,
    @Relation(parentColumn = "id", entityColumn = "questionId")
    val answers: List<AnswerEntity>
)
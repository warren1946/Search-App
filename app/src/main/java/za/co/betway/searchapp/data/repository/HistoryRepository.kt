/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.repository

import kotlinx.coroutines.flow.Flow
import za.co.betway.searchapp.data.local.dao.HistoryDao
import za.co.betway.searchapp.data.local.entity.QuestionWithAnswers
import za.co.betway.searchapp.domain.mapper.toEntity
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Question
import javax.inject.Inject

class HistoryRepository @Inject constructor(private val dao: HistoryDao) {
    suspend fun saveQuestionWithAnswers(question: Question, answers: List<Answer>) {
        if (answers.isEmpty()) return

        val count = dao.getCount()
        if (count >= 10) {
            dao.deleteOldestQuestion()
        }

        dao.deleteAnswersForQuestion(question.id)
        dao.insertQuestion(question.toEntity())
        dao.insertAnswers(answers.map { it.toEntity(question.id) })
    }

    fun getHistory(): Flow<List<QuestionWithAnswers>> = dao.getAllQuestions()

    fun getHistoryItem(id: Long): Flow<QuestionWithAnswers?> = dao.getQuestion(id)
}
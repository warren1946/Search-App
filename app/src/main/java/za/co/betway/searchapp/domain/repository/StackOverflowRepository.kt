package za.co.betway.searchapp.domain.repository

import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Question

interface StackOverflowRepository {
    suspend fun searchQuestions(query: String): List<Question>
    suspend fun getAnswers(questionId: Long): List<Answer>
}
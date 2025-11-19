package za.co.betway.searchapp.data.repository

import android.util.Log
import za.co.betway.searchapp.data.remote.api.StackOverflowApi
import za.co.betway.searchapp.data.remote.mapper.toDomain
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import javax.inject.Inject

class StackOverflowRepositoryImpl @Inject constructor(private val api: StackOverflowApi) : StackOverflowRepository {

    override suspend fun searchQuestions(query: String): List<Question> {
        return try {
            api.searchQuestions(title = query).items.map { it.toDomain() }
        } catch (e: Exception) {
            Log.d("StackOverflowRepositoryImpl - searchQuestions", e.toString())
            emptyList()
        }
    }

    override suspend fun getAnswers(questionId: Long): List<Answer> {
        return try {
            api.getAnswers(questionId).items.map { it.toDomain() }
        } catch (e: Exception) {
            Log.d("StackOverflowRepositoryImpl - getAnswers", e.toString())
            emptyList()
        }
    }
}
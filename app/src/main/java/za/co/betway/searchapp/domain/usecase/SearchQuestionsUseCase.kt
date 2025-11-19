package za.co.betway.searchapp.domain.usecase

import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import javax.inject.Inject

class SearchQuestionsUseCase @Inject constructor(private val repository: StackOverflowRepository) {
    suspend operator fun invoke(query: String): List<Question> = repository.searchQuestions(query)
}
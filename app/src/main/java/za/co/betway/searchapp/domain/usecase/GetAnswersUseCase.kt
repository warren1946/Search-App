package za.co.betway.searchapp.domain.usecase

import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import javax.inject.Inject

class GetAnswersUseCase @Inject constructor(private val repository: StackOverflowRepository) {
    suspend operator fun invoke(questionId: Long): List<Answer> = repository.getAnswers(questionId)
}
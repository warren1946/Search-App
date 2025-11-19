package za.co.betway.searchapp

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import za.co.betway.searchapp.domain.usecase.SearchQuestionsUseCase

@OptIn(ExperimentalCoroutinesApi::class)
class SearchQuestionsUseCaseTest {

    private val repository: StackOverflowRepository = mockk()
    private val useCase = SearchQuestionsUseCase(repository)

    @Test
    fun `Invoke Search Questions Use Case and return questions`() = runTest {
        val question = Question(
            id = 1,
            title = "Title",
            body = "Body",
            answersCount = 2,
            views = 100,
            votes = 10,
            isAnswered = true,
            author = Author("User", null, "link"),
            link = "link"
        )

        coEvery { repository.searchQuestions("Kotlin") } returns listOf(question)

        val result = useCase("Kotlin")

        assertEquals(1, result.size)
        assertEquals("Title", result.first().title)
    }
}
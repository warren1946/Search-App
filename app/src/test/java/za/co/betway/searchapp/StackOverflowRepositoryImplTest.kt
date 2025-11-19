/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test
import za.co.betway.searchapp.data.remote.api.StackOverflowApi
import za.co.betway.searchapp.data.remote.dto.answer.AnswerDto
import za.co.betway.searchapp.data.remote.dto.answer.AnswersResponse
import za.co.betway.searchapp.data.remote.dto.search.OwnerDto
import za.co.betway.searchapp.data.remote.dto.search.QuestionDto
import za.co.betway.searchapp.data.remote.dto.search.SearchResponse
import za.co.betway.searchapp.data.repository.StackOverflowRepositoryImpl

@OptIn(ExperimentalCoroutinesApi::class)
class StackOverflowRepositoryImplTest {

    private val api: StackOverflowApi = mockk()
    private val repository = StackOverflowRepositoryImpl(api)

    @Test
    fun `Test if searchQuestions returns mapped domain list`() = runTest {
        val dto = QuestionDto(
            questionId = 1,
            title = "Title",
            body = "Body",
            answerCount = 2,
            viewCount = 50,
            score = 5,
            isAnswered = true,
            owner = OwnerDto("User", null, "link"),
            link = "link",
            creationDate = 1575679448
        )

        coEvery { api.searchQuestions(title = "Kotlin") } returns SearchResponse(listOf(dto))

        val result = repository.searchQuestions("Kotlin")

        assertEquals(1, result.size)
        assertEquals("Title", result.first().title)
    }

    @Test
    fun `Test if getAnswers returns mapped domain list`() = runTest {
        val dto = AnswerDto(
            answerId = 10,
            questionId = 1,
            body = "Answer body",
            score = 3,
            isAccepted = true,
            owner = OwnerDto("User", null, "link")
        )

        coEvery { api.getAnswers(1) } returns AnswersResponse(listOf(dto))

        val result = repository.getAnswers(1)

        assertEquals(1, result.size)
        assertTrue(result.first().isAccepted)
    }
}
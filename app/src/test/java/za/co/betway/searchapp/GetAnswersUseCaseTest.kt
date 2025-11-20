/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.repository.StackOverflowRepository
import za.co.betway.searchapp.domain.usecase.GetAnswersUseCase

class GetAnswersUseCaseTest {

    private val repository: StackOverflowRepository = mockk()
    private val useCase = GetAnswersUseCase(repository)

    @Test
    fun `Invoke Get Answers Use Case and return answers`() = runTest {
        val answers = listOf(
            Answer(
                id = 10L,
                body = "Answer body",
                votes = 5,
                isAccepted = true,
                author = Author(
                    name = "Warren", profileImage = null, link = "link", reputation = 453
                ),
                creationDate = 53138172L
            )
        )

        coEvery { repository.getAnswers(53138172L) } returns answers

        val result = useCase(53138172L)

        assertEquals(1, result.size)
        assertEquals(10L, result.first().id)
        assertEquals(true, result.first().isAccepted)
        assertEquals("Warren", result.first().author.name)
    }
}
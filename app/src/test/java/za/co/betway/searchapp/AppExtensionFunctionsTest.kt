/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test
import za.co.betway.searchapp.data.remote.dto.answer.AnswerDto
import za.co.betway.searchapp.data.remote.dto.search.OwnerDto
import za.co.betway.searchapp.data.remote.dto.search.QuestionDto
import za.co.betway.searchapp.data.remote.mapper.toDomain

class AppExtensionFunctionsTest {

    @Test
    fun `Test if QuestionDto maps correctly to domain Question`() {
        val dto = QuestionDto(
            questionId = 123,
            title = "Test Question",
            body = "Body content",
            answerCount = 5,
            viewCount = 100,
            score = 10,
            isAnswered = true,
            owner = OwnerDto(
                "Warren", "image.png", "link", reputation = 2314
            ),
            link = "questionLink",
            creationDate = 1575679448,
            tags = listOf()
        )

        val domain = dto.toDomain()

        assertEquals(123, domain.id)
        assertEquals("Test Question", domain.title)
        assertEquals("Warren", domain.author.name)
        assertTrue(domain.isAnswered)
    }

    @Test
    fun `Test if AnswerDto maps correctly to domain Answer`() {
        val dto = AnswerDto(
            answerId = 456,
            questionId = 123,
            body = "Answer body",
            score = 20,
            isAccepted = false,
            owner = OwnerDto(
                "Copilot", null, "link", reputation = 1233
            ),
            creationDate = 1575679448
        )

        val domain = dto.toDomain()

        assertEquals(456, domain.id)
        assertEquals("Answer body", domain.body)
        assertEquals("Copilot", domain.author.name)
        assertFalse(domain.isAccepted)
    }
}
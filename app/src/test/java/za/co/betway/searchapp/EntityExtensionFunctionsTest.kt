/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp

import org.junit.Assert.assertEquals
import org.junit.Test
import za.co.betway.searchapp.data.local.entity.AnswerEntity
import za.co.betway.searchapp.data.local.entity.QuestionEntity
import za.co.betway.searchapp.domain.mapper.toDomain
import za.co.betway.searchapp.domain.mapper.toEntity
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question

class EntityExtensionFunctionsTest {

    @Test
    fun `Test if Question toEntity maps all fields correctly`() {
        val author = Author(
            name = "Alice",
            profileImage = "http://image.com/alice.png",
            link = "http://profile.com/alice",
            reputation = 1234
        )
        val question = Question(
            id = 1L,
            tags = listOf("kotlin", "compose"),
            title = "How to use Compose?",
            body = "Explain Jetpack Compose basics",
            answersCount = 2,
            views = 100,
            votes = 5,
            isAnswered = true,
            author = author,
            link = "http://stackoverflow.com/q/1",
            creationDate = 1700000000L
        )

        val entity = question.toEntity()

        assertEquals(question.id, entity.id)
        assertEquals(question.tags, entity.tags)
        assertEquals(question.title, entity.title)
        assertEquals(question.body, entity.body)
        assertEquals(question.answersCount, entity.answersCount)
        assertEquals(question.views, entity.views)
        assertEquals(question.votes, entity.votes)
        assertEquals(question.isAnswered, entity.isAnswered)
        assertEquals(question.author.name, entity.authorName)
        assertEquals(question.author.profileImage, entity.authorProfileImage)
        assertEquals(question.author.link, entity.authorLink)
        assertEquals(question.author.reputation, entity.authorReputation)
        assertEquals(question.link, entity.link)
        assertEquals(question.creationDate, entity.creationDate)
    }

    @Test
    fun `Test if Answer toEntity maps all fields correctly`() {
        val author = Author(
            name = "Bob",
            profileImage = "http://image.com/bob.png",
            link = "http://profile.com/bob",
            reputation = 567
        )
        val answer = Answer(
            id = 10L,
            body = "Use setContent in Activity",
            votes = 42,
            isAccepted = true,
            author = author,
            creationDate = 1700001111L
        )

        val entity = answer.toEntity(questionId = 1L)

        assertEquals(answer.id, entity.id)
        assertEquals(1L, entity.questionId)
        assertEquals(answer.body, entity.body)
        assertEquals(answer.votes, entity.votes)
        assertEquals(answer.isAccepted, entity.isAccepted)
        assertEquals(answer.author.name, entity.authorName)
        assertEquals(answer.author.profileImage, entity.authorProfileImage)
        assertEquals(answer.author.link, entity.authorLink)
        assertEquals(answer.author.reputation, entity.authorReputation)
        assertEquals(answer.creationDate, entity.creationDate)
    }

    @Test
    fun `Test if QuestionEntity toDomain maps all fields correctly`() {
        val entity = QuestionEntity(
            id = 2L,
            tags = listOf("android", "room"),
            title = "How to use Room?",
            body = "Explain Room basics",
            answersCount = 3,
            views = 200,
            votes = 10,
            isAnswered = false,
            authorName = "Charlie",
            authorProfileImage = "http://image.com/charlie.png",
            authorLink = "http://profile.com/charlie",
            authorReputation = 999,
            link = "http://stackoverflow.com/q/2",
            creationDate = 1700002222L
        )

        val domain = entity.toDomain()

        assertEquals(entity.id, domain.id)
        assertEquals(entity.tags, domain.tags)
        assertEquals(entity.title, domain.title)
        assertEquals(entity.body, domain.body)
        assertEquals(entity.answersCount, domain.answersCount)
        assertEquals(entity.views, domain.views)
        assertEquals(entity.votes, domain.votes)
        assertEquals(entity.isAnswered, domain.isAnswered)
        assertEquals(entity.authorName, domain.author.name)
        assertEquals(entity.authorProfileImage, domain.author.profileImage)
        assertEquals(entity.authorLink, domain.author.link)
        assertEquals(entity.authorReputation, domain.author.reputation)
        assertEquals(entity.link, domain.link)
        assertEquals(entity.creationDate, domain.creationDate)
    }

    @Test
    fun `Test if QuestionEntity toDomain uses override answersCount`() {
        val entity = QuestionEntity(
            id = 3L,
            tags = listOf("override"),
            title = "Override test",
            body = "Body",
            answersCount = 5,
            views = 50,
            votes = 2,
            isAnswered = true,
            authorName = "Dana",
            authorProfileImage = null,
            authorLink = "http://profile.com/dana",
            authorReputation = 100,
            link = "http://stackoverflow.com/q/3",
            creationDate = 1700003333L
        )

        val domain = entity.toDomain(answersCountOverride = 99)

        assertEquals(99, domain.answersCount)
    }

    @Test
    fun `Test if AnswerEntity toDomain maps all fields correctly`() {
        val entity = AnswerEntity(
            id = 20L,
            questionId = 2L,
            body = "Room uses annotations",
            votes = 7,
            isAccepted = false,
            authorName = "Eve",
            authorProfileImage = "http://image.com/eve.png",
            authorLink = "http://profile.com/eve",
            authorReputation = 321,
            creationDate = 1700004444L
        )

        val domain = entity.toDomain()

        assertEquals(entity.id, domain.id)
        assertEquals(entity.body, domain.body)
        assertEquals(entity.votes, domain.votes)
        assertEquals(entity.isAccepted, domain.isAccepted)
        assertEquals(entity.authorName, domain.author.name)
        assertEquals(entity.authorProfileImage, domain.author.profileImage)
        assertEquals(entity.authorLink, domain.author.link)
        assertEquals(entity.authorReputation, domain.author.reputation)
        assertEquals(entity.creationDate, domain.creationDate)
    }
}
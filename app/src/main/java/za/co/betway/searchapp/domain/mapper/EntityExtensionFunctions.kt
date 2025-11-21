/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.domain.mapper

import za.co.betway.searchapp.data.local.entity.AnswerEntity
import za.co.betway.searchapp.data.local.entity.QuestionEntity
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question

fun Question.toEntity(): QuestionEntity = QuestionEntity(
    id = id,
    tags = tags,
    title = title,
    body = body,
    answersCount = answersCount,
    views = views,
    votes = votes,
    isAnswered = isAnswered,
    authorName = author.name,
    authorProfileImage = author.profileImage,
    authorLink = author.link,
    authorReputation = author.reputation,
    link = link,
    creationDate = creationDate
)

fun Answer.toEntity(questionId: Long): AnswerEntity = AnswerEntity(
    id = id,
    questionId = questionId,
    body = body,
    votes = votes,
    isAccepted = isAccepted,
    authorName = author.name,
    authorProfileImage = author.profileImage,
    authorLink = author.link,
    authorReputation = author.reputation,
    creationDate = creationDate
)

fun QuestionEntity.toDomain(answersCountOverride: Int? = null): Question = Question(
    id = id,
    tags = tags,
    title = title,
    body = body,
    answersCount = answersCountOverride ?: answersCount,
    views = views,
    votes = votes,
    isAnswered = isAnswered,
    author = Author(
        name = authorName,
        profileImage = authorProfileImage,
        link = authorLink,
        reputation = authorReputation
    ),
    link = link,
    creationDate = creationDate
)

fun AnswerEntity.toDomain(): Answer = Answer(
    id = id,
    body = body,
    votes = votes,
    isAccepted = isAccepted,
    author = Author(
        name = authorName,
        profileImage = authorProfileImage,
        link = authorLink,
        reputation = authorReputation
    ),
    creationDate = creationDate
)
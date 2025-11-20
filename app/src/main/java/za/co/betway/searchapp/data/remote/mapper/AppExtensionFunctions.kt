/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.remote.mapper

import za.co.betway.searchapp.data.remote.dto.answer.AnswerDto
import za.co.betway.searchapp.data.remote.dto.search.QuestionDto
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun QuestionDto.toDomain() = Question(
    id = questionId,
    tags = tags,
    title = title,
    body = body,
    answersCount = answerCount,
    views = viewCount,
    votes = score,
    isAnswered = isAnswered,
    author = Author(
        name = owner.displayName,
        profileImage = owner.profileImage,
        link = owner.link,
        reputation = owner.reputation
    ),
    link = link,
    creationDate = creationDate
)

fun AnswerDto.toDomain() = Answer(
    id = answerId,
    body = body,
    votes = score,
    isAccepted = isAccepted,
    author = Author(
        name = owner.displayName,
        profileImage = owner.profileImage,
        link = owner.link,
        reputation = owner.reputation
    ),
    creationDate = creationDate
)

fun Question.formattedCreationDate(): String {
    val instant = Instant.ofEpochSecond(creationDate)
    val formatter = DateTimeFormatter.ofPattern("MMM d ''yy").withZone(ZoneId.systemDefault())
    return formatter.format(instant)
}
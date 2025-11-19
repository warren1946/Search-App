package za.co.betway.searchapp.data.remote.dto

import za.co.betway.searchapp.data.remote.dto.answer.AnswerDto
import za.co.betway.searchapp.data.remote.dto.search.QuestionDto
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question

fun QuestionDto.toDomain() = Question(
    id = questionId,
    title = title,
    body = body,
    answersCount = answerCount,
    views = viewCount,
    votes = score,
    isAnswered = isAnswered,
    author = Author(
        name = owner.displayName,
        profileImage = owner.profileImage,
        link = owner.link
    ),
    link = link
)

fun AnswerDto.toDomain() = Answer(
    id = answerId,
    body = body,
    votes = score,
    isAccepted = isAccepted,
    author = Author(
        name = owner.displayName,
        profileImage = owner.profileImage,
        link = owner.link
    )
)
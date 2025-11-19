package za.co.betway.searchapp.data.remote.dto.search

import com.squareup.moshi.Json

data class QuestionDto(
    @Json(name = "question_id") val questionId: Long,
    val title: String,
    val body: String,
    @Json(name = "answer_count") val answerCount: Int,
    @Json(name = "view_count") val viewCount: Int,
    val score: Int,
    @Json(name = "is_answered") val isAnswered: Boolean,
    val owner: OwnerDto,
    val link: String
)
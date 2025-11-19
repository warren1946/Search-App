package za.co.betway.searchapp.data.remote.dto.answer

import com.squareup.moshi.Json
import za.co.betway.searchapp.data.remote.dto.search.OwnerDto

data class AnswerDto(
    @Json(name = "answer_id") val answerId: Long,
    @Json(name = "question_id") val questionId: Long,
    val body: String,
    val score: Int,
    @Json(name = "is_accepted") val isAccepted: Boolean,
    val owner: OwnerDto
)
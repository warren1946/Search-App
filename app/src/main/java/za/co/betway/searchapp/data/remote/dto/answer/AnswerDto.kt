/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.remote.dto.answer

import com.squareup.moshi.Json
import za.co.betway.searchapp.data.remote.dto.search.OwnerDto

data class AnswerDto(
    @Json(name = "answer_id") val answerId: Long,
    @Json(name = "question_id") val questionId: Long,
    val body: String,
    val score: Int,
    @Json(name = "is_accepted") val isAccepted: Boolean,
    val owner: OwnerDto,
    @Json(name = "creation_date") val creationDate: Long
)
/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.domain.model

data class Answer(
    val id: Long,
    val body: String,
    val votes: Int,
    val isAccepted: Boolean,
    val author: Author,
    val creationDate: Long
)
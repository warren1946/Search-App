/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Question(
    val id: Long,
    val tags: List<String>,
    val title: String,
    val body: String,
    val answersCount: Int,
    val views: Int,
    val votes: Int,
    val isAnswered: Boolean,
    val author: Author,
    val link: String,
    val creationDate: Long
) : Parcelable
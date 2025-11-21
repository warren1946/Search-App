/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "questions")
data class QuestionEntity(
    @PrimaryKey val id: Long,
    val tags: List<String>,
    val title: String,
    val body: String,
    val answersCount: Int,
    val views: Int,
    val votes: Int,
    val isAnswered: Boolean,
    val authorName: String,
    val authorProfileImage: String?,
    val authorLink: String,
    val authorReputation: Int,
    val link: String,
    val creationDate: Long
)
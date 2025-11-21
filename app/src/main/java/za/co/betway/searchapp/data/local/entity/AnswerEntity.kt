/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.local.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(
    tableName = "answers",
    foreignKeys = [ForeignKey(
        entity = QuestionEntity::class,
        parentColumns = ["id"],
        childColumns = ["questionId"],
        onDelete = ForeignKey.CASCADE
    )],
    indices = [Index("questionId")]
)
data class AnswerEntity(
    @PrimaryKey val id: Long,
    val questionId: Long,
    val body: String,
    val votes: Int,
    val isAccepted: Boolean,
    val authorName: String,
    val authorProfileImage: String?,
    val authorLink: String,
    val authorReputation: Int,
    val creationDate: Long
)
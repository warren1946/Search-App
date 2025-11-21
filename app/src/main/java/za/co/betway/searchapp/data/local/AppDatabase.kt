/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import za.co.betway.searchapp.data.local.dao.HistoryDao
import za.co.betway.searchapp.data.local.entity.AnswerEntity
import za.co.betway.searchapp.data.local.entity.QuestionEntity

@Database(entities = [QuestionEntity::class, AnswerEntity::class], version = 1, exportSchema = false)
@TypeConverters(TagsConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun historyDao(): HistoryDao
}

class TagsConverter {
    @TypeConverter
    fun fromList(tags: List<String>): String = tags.joinToString("|")

    @TypeConverter
    fun toList(str: String): List<String> = if (str.isBlank()) emptyList() else str.split("|")
}
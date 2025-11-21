/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import kotlinx.coroutines.flow.Flow
import za.co.betway.searchapp.data.local.entity.AnswerEntity
import za.co.betway.searchapp.data.local.entity.QuestionEntity
import za.co.betway.searchapp.data.local.entity.QuestionWithAnswers

@Dao
interface HistoryDao {

    @Transaction
    @Query("SELECT * FROM questions ORDER BY creationDate DESC")
    fun getAllQuestions(): Flow<List<QuestionWithAnswers>>

    @Transaction
    @Query("SELECT * FROM questions WHERE id = :id")
    fun getQuestion(id: Long): Flow<QuestionWithAnswers?>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: QuestionEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnswers(answers: List<AnswerEntity>)

    @Query("DELETE FROM answers WHERE questionId = :questionId")
    suspend fun deleteAnswersForQuestion(questionId: Long)

    @Query("SELECT COUNT(*) FROM questions")
    suspend fun getCount(): Int

    @Query("DELETE FROM questions WHERE id IN (SELECT id FROM questions ORDER BY creationDate ASC LIMIT 1)")
    suspend fun deleteOldestQuestion()
}
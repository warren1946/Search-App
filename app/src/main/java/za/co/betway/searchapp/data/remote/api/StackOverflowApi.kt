package za.co.betway.searchapp.data.remote.api

import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import za.co.betway.searchapp.data.remote.dto.answer.AnswersResponse
import za.co.betway.searchapp.data.remote.dto.search.SearchResponse

interface StackOverflowApi {
    @GET("2.2/search/advanced")
    suspend fun searchQuestions(
        @Query("pagesize") pagesize: Int = 20,
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("title") title: String,
        @Query("site") site: String = "stackoverflow",
        @Query("filter") filter: String = "withbody"
    ): SearchResponse

    @GET("2.2/questions/{id}/answers")
    suspend fun getAnswers(
        @Path("id") questionId: Long,
        @Query("order") order: String = "desc",
        @Query("sort") sort: String = "activity",
        @Query("site") site: String = "stackoverflow",
        @Query("filter") filter: String = "withbody"
    ): AnswersResponse
}
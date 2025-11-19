package za.co.betway.searchapp.domain.model

data class Question(
    val id: Long,
    val title: String,
    val body: String,
    val answersCount: Int,
    val views: Int,
    val votes: Int,
    val isAnswered: Boolean,
    val author: Author,
    val link: String
)
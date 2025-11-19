package za.co.betway.searchapp.domain.model

data class Answer(
    val id: Long,
    val body: String,
    val votes: Int,
    val isAccepted: Boolean,
    val author: Author
)
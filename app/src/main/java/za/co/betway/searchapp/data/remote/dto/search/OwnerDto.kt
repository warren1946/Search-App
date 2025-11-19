package za.co.betway.searchapp.data.remote.dto.search

import com.squareup.moshi.Json

data class OwnerDto(
    @Json(name = "display_name") val displayName: String,
    @Json(name = "profile_image") val profileImage: String?,
    val link: String
)
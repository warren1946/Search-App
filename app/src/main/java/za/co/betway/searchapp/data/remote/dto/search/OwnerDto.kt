/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.data.remote.dto.search

import com.squareup.moshi.Json

data class OwnerDto(
    @Json(name = "display_name") val displayName: String,
    @Json(name = "profile_image") val profileImage: String?,
    val link: String,
    val reputation: Int
)
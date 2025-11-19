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
data class Author(
    val name: String,
    val profileImage: String?,
    val link: String
) : Parcelable
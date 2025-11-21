/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.shared.component.mapper

import androidx.core.text.HtmlCompat

fun String.decodeHtml(): String = HtmlCompat.fromHtml(this, HtmlCompat.FROM_HTML_MODE_LEGACY).toString()
/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
import java.util.concurrent.TimeUnit

fun Long.toRelativeTime(): String {
    val now = System.currentTimeMillis() / 1000
    val diff = now - this

    val minutes = TimeUnit.SECONDS.toMinutes(diff)
    val hours = TimeUnit.SECONDS.toHours(diff)
    val days = TimeUnit.SECONDS.toDays(diff)
    val weeks = days / 7
    val months = days / 30
    val years = days / 365

    return when {
        minutes < 60 -> "$minutes minute(s) ago"
        hours < 24 -> "$hours hour(s) ago"
        days < 7 -> "$days day(s) ago"
        weeks < 4 -> "$weeks week(s) ago"
        months < 12 -> "$months month(s) ago"
        else -> "$years year(s) ago"
    }
}

fun Long.toFormattedDateTime(): String {
    val date = Date(this * 1000)
    val formatter = SimpleDateFormat("MMM dd yyyy 'at' HH:mm", Locale.getDefault())
    return formatter.format(date)
}

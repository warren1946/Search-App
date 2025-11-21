/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.ui.shared.component.mapper.decodeHtml

@Composable
fun AuthorInfo(author: Author, modifier: Modifier = Modifier) {
    Row(verticalAlignment = Alignment.Top) {
        AsyncImage(
            modifier = modifier
                .size(60.dp)
                .clip(CircleShape),
            model = author.profileImage,
            contentDescription = "Author profile"
        )
        Spacer(modifier.width(8.dp))
        Column {
            Text(
                text = author.name.decodeHtml(),
                style = AppTypography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "${author.reputation}",
                style = AppTypography.bodySmall.copy(fontWeight = FontWeight.Bold),
                color = MaterialTheme.colorScheme.onSurface
            )
        }
    }
}
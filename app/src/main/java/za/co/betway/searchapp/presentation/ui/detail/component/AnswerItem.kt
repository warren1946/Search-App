/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.R
import za.co.betway.searchapp.domain.model.Answer
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.theme.Orange
import za.co.betway.searchapp.presentation.ui.shared.component.HtmlText
import za.co.betway.searchapp.presentation.utils.toFormattedDateTime

@Composable
fun AnswerItem(
    answer: Answer,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        verticalAlignment = Alignment.Top
    ) {
        Column(
            modifier = Modifier.width(64.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Text(
                text = "${answer.votes}",
                style = AppTypography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = "Votes",
                style = AppTypography.bodySmall,
                textAlign = TextAlign.Center,
                color = MaterialTheme.colorScheme.onSurface
            )
            Spacer(Modifier.height(4.dp))
            Icon(
                modifier = Modifier.size(24.dp),
                painter = painterResource(id = R.drawable.ic_check),
                contentDescription = "Answered",
                tint = Orange
            )
        }

        Spacer(Modifier.width(12.dp))
        Column(
            modifier = Modifier
                .weight(1f)
                .padding(end = 16.dp)
        ) {
            HtmlText(html = answer.body, shouldTruncateBody = false)
            Spacer(Modifier.height(8.dp))
            Row {
                Text(
                    text = "Asked ",
                    style = AppTypography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
                )
                Text(
                    text = answer.creationDate.toFormattedDateTime(),
                    style = AppTypography.bodySmall.copy(
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.onSurface
                    )
                )
            }
            Spacer(Modifier.height(4.dp))
            AuthorInfo(author = answer.author)
            Spacer(Modifier.height(4.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun AnswerItemPreview() {
    MaterialTheme {
        AnswerItem(
            answer = Answer(
                id = 12345,
                body = "<p>This is a sample answer body with <b>HTML</b> content.</p>",
                votes = 42,
                creationDate = 1700000000,
                author = Author(
                    name = "Jane Doe",
                    profileImage = "https://example.com/profile.jpg",
                    link = "",
                    reputation = 1500
                ),
                isAccepted = false
            ),
            modifier = Modifier.padding(16.dp)
        )
    }
}
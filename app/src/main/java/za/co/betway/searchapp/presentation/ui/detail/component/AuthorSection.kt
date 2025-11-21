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
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.utils.toFormattedDateTime

@Composable
fun AuthorSection(question: Question) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Row {
            Text(
                text = "Asked ",
                style = AppTypography.bodySmall.copy(color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f))
            )
            Text(
                text = question.creationDate.toFormattedDateTime(),
                style = AppTypography.bodySmall.copy(
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSurface
                )
            )
        }

        Spacer(Modifier.height(8.dp))
        AuthorInfo(author = question.author)
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorSectionPreview() {
    val sampleQuestion = Question(
        id = 1,
        tags = listOf(),
        title = "Sample Question",
        body = "<p>This is a sample question body.</p>",
        answersCount = 2,
        views = 100,
        votes = 10,
        isAnswered = true,
        author = Author(
            name = "John Doe",
            profileImage = "https://avatar.iran.liara.run/public/11",
            link = "https://example.com/johndoe",
            reputation = 1500
        ),
        link = "https://example.com/samplequestion",
        creationDate = 1694017779L
    )
    AuthorSection(question = sampleQuestion)
}
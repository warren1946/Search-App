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
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.theme.outlineLightHighContrast
import za.co.betway.searchapp.presentation.ui.common.HtmlText
import za.co.betway.searchapp.presentation.utils.toRelativeTime

@Composable
fun InformationHeader(question: Question) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Text(question.title, style = AppTypography.titleLarge)

        Spacer(Modifier.height(8.dp))
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(
                text = "Asked ",
                style = AppTypography.bodySmall.copy(color = outlineLightHighContrast.copy(alpha = 0.6f))
            )
            Text(
                text = question.creationDate.toRelativeTime(),
                style = AppTypography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = "Viewed ",
                style = AppTypography.bodySmall.copy(color = Color.Gray.copy(alpha = 0.6f))
            )
            Text(
                text = "${question.views} times",
                style = AppTypography.bodySmall.copy(fontWeight = FontWeight.Bold)
            )
        }

        HorizontalDivider(Modifier.padding(vertical = 8.dp))

        HtmlText(html = question.body, shouldTruncateBody = false)
    }
}

@Preview(showBackground = true)
@Composable
fun InformationHeaderPreview() {
    MaterialTheme {
        InformationHeader(
            question = Question(
                id = 77053797,
                tags = listOf(),
                title = "Java virtual threads vs Kotlin coroutines",
                body = "<p>In Kotlin I can:</p>\n\n<pre><code>val (specificMembers, regularMembers) = members.partition {it is SpecificMember}\n</code></pre>\n\n<p>However to my knowledge I can not do something like:</p>\n\n<pre><code>val (specificMembers as List&lt;SpecificMember&gt;, regularMembers) = members.partition {it is SpecificMember}\n</code></pre>\n\n<p>My question would be - is there's an idiomatic way to partition iterable by class and typecast it those partitioned parts if needed. </p>\n",
                answersCount = 5,
                views = 22160,
                votes = 37,
                isAnswered = true,
                author = Author("Mahozad", profileImage = null, link = "", reputation = 2345),
                link = "https://stackoverflow.com/questions/77053797/java-virtual-threads-vs-kotlin-coroutines",
                creationDate = 1694017779L
            )
        )
    }
}
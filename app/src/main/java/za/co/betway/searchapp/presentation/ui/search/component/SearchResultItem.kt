/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.search.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.R
import za.co.betway.searchapp.data.remote.mapper.decodeHtml
import za.co.betway.searchapp.data.remote.mapper.formattedCreationDate
import za.co.betway.searchapp.domain.model.Author
import za.co.betway.searchapp.domain.model.Question
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.theme.primaryContainerLightMediumContrast
import za.co.betway.searchapp.presentation.theme.surfaceDark
import za.co.betway.searchapp.presentation.ui.shared.component.HtmlText

@Composable
fun SearchResultItem(
    question: Question,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_check),
            contentDescription = "Answered",
            tint = primaryContainerLightMediumContrast,
            modifier = Modifier.size(24.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text("Q: ${question.title.decodeHtml()}", style = AppTypography.titleMedium, color = Color.Blue)
            HtmlText(html = question.body, modifier = Modifier.padding(top = 4.dp))
            Spacer(modifier = Modifier.height(10.dp))
            Row {
                Text(
                    text = "asked ${question.formattedCreationDate()} by ",
                    style = AppTypography.bodySmall
                )
                Text(
                    text = question.author.name.decodeHtml(),
                    style = AppTypography.bodySmall.copy(color = Color.Blue)
                )
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = Modifier.widthIn(min = 60.dp)
        ) {
            Text("${question.answersCount} answers", style = AppTypography.bodySmall)
            Text("${question.votes} votes", style = AppTypography.bodySmall)
            Text("${question.views} views", style = AppTypography.bodySmall)
        }
        Spacer(modifier = Modifier.width(8.dp))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "Go to detail",
            tint = surfaceDark,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun SearchResultItemPreview() {
    MaterialTheme {
        SearchResultItem(
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
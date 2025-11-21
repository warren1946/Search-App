/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.detail.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.presentation.theme.AppTypography
import za.co.betway.searchapp.presentation.ui.detail.AnswerFilter

@Composable
fun AnswersHeader(
    answerCount: Int,
    selectedFilter: AnswerFilter,
    onFilterSelected: (AnswerFilter) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 16.dp),
                text = "$answerCount Answers",
                style = AppTypography.titleMedium,
                color = MaterialTheme.colorScheme.onSurface
            )
            FlowRow(
                modifier = Modifier.padding(horizontal = 16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                AnswerFilter.entries.forEach { filter ->
                    val isSelected = filter == selectedFilter
                    Surface(
                        modifier = Modifier.clickable { onFilterSelected(filter) },
                        shape = RoundedCornerShape(3.dp),
                        color = if (isSelected) Color.Gray else Color.White,
                        border = BorderStroke(1.dp, Color.Gray)
                    ) {
                        Text(
                            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
                            text = filter.name,
                            style = AppTypography.bodySmall,
                            color = if (isSelected) Color.White else Color.Black
                        )
                    }
                }
            }
        }
        HorizontalDivider(modifier = Modifier.padding(top = 8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAnswersHeader() {
    var selectedFilter by remember { mutableStateOf(AnswerFilter.Votes) }

    AnswersHeader(
        answerCount = 5,
        selectedFilter = selectedFilter,
        onFilterSelected = { selectedFilter = it }
    )
}
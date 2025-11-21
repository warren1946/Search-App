/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.shared.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBackIos
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import za.co.betway.searchapp.presentation.theme.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailTopAppBar(title: String, onBackClick: () -> Unit) {
    Column {
        CenterAlignedTopAppBar(
            title = {
                Text(title, style = AppTypography.titleMedium)
            },
            navigationIcon = {
                Row(
                    modifier = Modifier
                        .clickable { onBackClick() }
                        .padding(horizontal = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBackIos,
                        contentDescription = "Back"
                    )
                    Spacer(Modifier.width(4.dp))
                    Text("Back", style = AppTypography.bodyMedium)
                }
            }
        )
        HorizontalDivider()
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewDetailTopAppBar() {
    DetailTopAppBar("More Info", onBackClick = {})
}
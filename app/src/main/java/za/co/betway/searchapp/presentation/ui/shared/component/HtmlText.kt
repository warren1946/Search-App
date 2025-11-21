/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.shared.component

import android.graphics.Typeface
import android.text.Html
import android.text.TextUtils
import android.widget.TextView
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.viewinterop.AndroidView
import za.co.betway.searchapp.presentation.theme.AppTypography

@Composable
fun HtmlText(
    modifier: Modifier = Modifier,
    html: String,
    shouldTruncateBody: Boolean = true,
    textStyle: TextStyle = AppTypography.bodySmall,
    color: Color = MaterialTheme.colorScheme.onSurface
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context).apply {
                textSize = textStyle.fontSize.value
                typeface = Typeface.DEFAULT

                if (shouldTruncateBody) {
                    maxLines = 3
                    ellipsize = TextUtils.TruncateAt.END
                }
            }
        },
        update = { textView ->
            textView.setTextColor(color.toArgb())
            textView.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        }
    )
}
/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.ui.common

import android.graphics.Typeface
import android.text.Html
import android.text.TextUtils
import android.widget.TextView
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.viewinterop.AndroidView
import za.co.betway.searchapp.presentation.theme.AppTypography

@Composable
fun HtmlText(
    html: String,
    modifier: Modifier = Modifier,
    textStyle: TextStyle = AppTypography.bodySmall
) {
    AndroidView(
        modifier = modifier,
        factory = { context ->
            TextView(context).apply {
                textSize = textStyle.fontSize.value
                typeface = Typeface.DEFAULT

                maxLines = 3
                ellipsize = TextUtils.TruncateAt.END
            }
        },
        update = { textView ->
            textView.text = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY)
        }
    )
}
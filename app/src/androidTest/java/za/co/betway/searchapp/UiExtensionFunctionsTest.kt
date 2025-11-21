/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp

import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import za.co.betway.searchapp.presentation.ui.shared.component.mapper.decodeHtml

@RunWith(AndroidJUnit4::class)
class UiExtensionFunctionsTest {

    @Test
    fun convertsBoldTagsToPlainText() {
        val html = "<b>Hello</b> World"
        val decoded = html.decodeHtml()
        Assert.assertEquals("Hello World", decoded)
    }

    @Test
    fun convertItalicTagsToPlainText() {
        val html = "This is <i>italic</i> text"
        val decoded = html.decodeHtml()
        Assert.assertEquals("This is italic text", decoded)
    }

    @Test
    fun convertsLinksToPlainText() {
        val html = "Visit <a href='http://example.com'>Example</a>"
        val decoded = html.decodeHtml()
        Assert.assertEquals("Visit Example", decoded)
    }

    @Test
    fun handleEmptyString() {
        val html = ""
        val decoded = html.decodeHtml()
        Assert.assertEquals("", decoded)
    }

    @Test
    fun decodeHTMLEntities() {
        val html = "5 &lt; 10 &amp;&amp; 20 &gt; 15"
        val decoded = html.decodeHtml()
        Assert.assertEquals("5 < 10 && 20 > 15", decoded)
    }
}
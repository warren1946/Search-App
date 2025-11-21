/*
 * Copyright (c) 2025 Warren Mtawu.
 * Open Source under the MIT License.
 * Permission granted for use, modification, and distribution with attribution.
 * No warranty provided.
 */

package za.co.betway.searchapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val StackOverflowLightColors = lightColorScheme(
    primary = Orange,
    onPrimary = OnPrimaryLight,
    primaryContainer = Orange.copy(alpha = 0.12f),
    onPrimaryContainer = Orange,

    secondary = Blue,
    onSecondary = Color.White,
    secondaryContainer = Blue.copy(alpha = 0.12f),
    onSecondaryContainer = Blue,

    tertiary = Yellow,
    onTertiary = Color.Black,
    tertiaryContainer = Yellow.copy(alpha = 0.12f),
    onTertiaryContainer = Yellow,

    background = BackgroundLight,
    onBackground = OnSurfaceLight,
    surface = SurfaceLight,
    onSurface = OnSurfaceLight,

    surfaceVariant = Gray.copy(alpha = 0.25f),
    onSurfaceVariant = Black,

    outline = OutlineLight,
    outlineVariant = Gray,

    error = Color(0xFFBA1A1A),
    onError = Color.White,
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002)
)

private val StackOverflowDarkColors = darkColorScheme(
    primary = Orange,
    onPrimary = OnPrimaryDark,
    primaryContainer = Orange.copy(alpha = 0.18f),
    onPrimaryContainer = Orange,

    secondary = Blue,
    onSecondary = Color.Black,
    secondaryContainer = Blue.copy(alpha = 0.18f),
    onSecondaryContainer = Blue,

    tertiary = Yellow,
    onTertiary = Color.Black,
    tertiaryContainer = Yellow.copy(alpha = 0.18f),
    onTertiaryContainer = Yellow,

    background = BackgroundDark,
    onBackground = OnSurfaceDark,
    surface = SurfaceDark,
    onSurface = OnSurfaceDark,

    surfaceVariant = Black.copy(alpha = 0.35f),
    onSurfaceVariant = Gray,

    outline = OutlineDark,
    outlineVariant = Black,

    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable() () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            if (darkTheme) StackOverflowDarkColors else StackOverflowLightColors
        }

        darkTheme -> StackOverflowDarkColors
        else -> StackOverflowLightColors
    }
    val systemUiController = rememberSystemUiController()

    SideEffect {
        systemUiController.setStatusBarColor(
            color = colorScheme.primary,
            darkIcons = !darkTheme
        )
        systemUiController.setNavigationBarColor(
            color = colorScheme.surface,
            darkIcons = !darkTheme
        )
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = AppTypography,
        content = content
    )
}
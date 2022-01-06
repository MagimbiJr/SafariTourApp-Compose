package com.tana.safaritour.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorPalette = darkColors(
    primary = BottleGreen,
    onPrimary = Cultured,
    background = EerieBlack,
    onBackground = Cultured,
    secondary = OpaqueDark,
)

private val LightColorPalette = lightColors(
    primary = BottleGreen,
    onPrimary = Cultured,
    background = Color.White,
    onBackground = RussianViolet,
    secondary = AliceBlue,
    surface = Cultured,
    onSurface = Color.Black
)

@Composable
fun SafariTourTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable () -> Unit) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
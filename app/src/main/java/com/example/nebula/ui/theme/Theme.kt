package com.example.nebula.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.darkColorScheme
import androidx.tv.material3.lightColorScheme

@Composable
fun NebulaTheme(
    isInDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (isInDarkTheme) {
        darkColorScheme(
            primary = Purple80,
            secondary = PurpleGrey80,
            tertiary = Pink80
        )
    } else {
        lightColorScheme(
            primary = Purple40,
            secondary = PurpleGrey40,
            tertiary = Pink40
        )
    }
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

//package com.example.nebula.tv
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.Color
//import androidx.tv.material3.ColorScheme
//import androidx.tv.material3.MaterialTheme // From androidx.tv.material
//
//// Define your Color objects (e.g., in a TvColors.kt file)
//// import androidx.compose.ui.graphics.Color
//val TvPurple200 = Color(0xFFBB86FC)
//val TvPurple700 = Color(0xFF3700B3)
//val TvTeal200 = Color(0xFF03DAC5)
//val TvSurface = Color(0xFF121212) // Dark surface
//val TvError = Color(0xFFCF6679)
//
//// Define your TV color palette
//private val TvDarkColorPalette = ColorScheme(
//    primary = TvPurple200, // Define these Color objects
//    inversePrimary = TvPurple700,
//    secondary = TvTeal200,
////    secondaryVariant = TvTeal200,
//    background = Color.Black, // Example
//    surface = TvSurface,      // Example
//    error = TvError,          // Example
//    onPrimary = Color.Black,
//    onSecondary = Color.Black,
//    onBackground = Color.White,
//    onSurface = Color.White,
//    onError = Color.Black,
//    primaryContainer = TODO(),
//    onPrimaryContainer = TODO(),
//
//    secondaryContainer = TODO(),
//    onSecondaryContainer = TODO(),
//    tertiary = TODO(),
//    onTertiary = TODO(),
//    tertiaryContainer = TODO(),
//    onTertiaryContainer = TODO(),
//    surfaceVariant = TODO(),
//    onSurfaceVariant = TODO(),
//    surfaceTint = TODO(),
//    inverseSurface = TODO(),
//    inverseOnSurface = TODO(),
//    errorContainer = TODO(),
//    onErrorContainer = TODO(),
//    border = TODO(),
//    borderVariant = TODO(),
//    scrim = TODO(),
////    isLight = false
//)
//
//@Composable
//fun NebulaTvMaterialTheme( // Renamed to avoid clash if you have a mobile theme
//    content: @Composable () -> Unit
//) {
//    MaterialTheme( // This is androidx.tv.material.MaterialTheme
//        colors = TvDarkColorPalette,
//        // typography = TvTypography, // You would define TvTypography similarly
//        // shapes = TvShapes,       // You would define TvShapes similarly
//        content = content
//    )
//}
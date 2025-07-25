//package com.example.nebula.tv
//
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.graphics.Color
//import androidx.tv.material3.Colors
//import androidx.tv.material3.MaterialTheme // From androidx.tv.material
//
//// Define your TV color palette
//private val TvDarkColorPalette = Colors(
//    primary = TvPurple200, // Define these Color objects
//    primaryVariant = TvPurple700,
//    secondary = TvTeal200,
//    secondaryVariant = TvTeal200,
//    background = Color.Black, // Example
//    surface = TvSurface,      // Example
//    error = TvError,          // Example
//    onPrimary = Color.Black,
//    onSecondary = Color.Black,
//    onBackground = Color.White,
//    onSurface = Color.White,
//    onError = Color.Black,
//    isLight = false
//)
//
//// Define your Color objects (e.g., in a TvColors.kt file)
//// import androidx.compose.ui.graphics.Color
//// val TvPurple200 = Color(0xFFBB86FC)
//// val TvPurple700 = Color(0xFF3700B3)
//// val TvTeal200 = Color(0xFF03DAC5)
//// val TvSurface = Color(0xFF121212) // Dark surface
//// val TvError = Color(0xFFCF6679)
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
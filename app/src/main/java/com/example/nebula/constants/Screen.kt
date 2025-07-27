package com.example.nebula.constants

import androidx.compose.ui.graphics.vector.ImageVector

// Define your screens (could be in a separate file)
enum class ViewScreen(val title: String, val icon: ImageVector? = null) { // Add icons later
    WIDGETS("Widgets" /*, Icons.Filled.Dashboard */),
    APP_GRID("Apps" /*, Icons.Filled.Apps */),
    BROWSER("Browser" /*, Icons.Filled.Web */)
    // Add Settings, Media, etc. as needed
}
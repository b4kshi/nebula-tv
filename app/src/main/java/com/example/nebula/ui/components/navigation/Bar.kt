package com.example.nebula.ui.components.navigation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Surface
import com.example.nebula.constants.ViewScreen

@Composable
fun NavigationBar(
    currentScreen: ViewScreen,
    onScreenSelected: (ViewScreen) -> Unit,
    modifier: Modifier = Modifier
) {
    // For Glass morphism, the background of the bar itself needs to be semi-transparent
    // and potentially have a blur effect if we can apply it.
    // androidx.compose.ui.draw.blur is not directly available on Android TV for background blur
    // We might need to simulate it or use other techniques for a glass-like feel.

    Surface(
        // Use Surface for elevation and shape, good for TV components
        modifier = modifier
            .fillMaxWidth()
            .height(72.dp), // Typical height for a bottom bar
        shape = RectangleShape, // Or a slightly rounded top shape
//        color = Color.Black.copy(alpha = 0.5f), // Semi-transparent for glass morphism start
//        border = Border(BorderStroke(1.dp, Color.White.copy(alpha = 0.1f))), 1.dp, Color.White.copy(alpha = 0.1f)) // Subtle border
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceAround // Or SpaceBetween
        ) {
            // Navigation Items
            NavigationItem(
                label = "Widgets",
                isSelected = currentScreen == ViewScreen.WIDGETS,
                onClick = { onScreenSelected(ViewScreen.WIDGETS) }
            )
            NavigationItem(
                label = "Apps",
                isSelected = currentScreen == ViewScreen.APP_GRID,
                onClick = { onScreenSelected(ViewScreen.APP_GRID) }
            )
            NavigationItem(
                label = "Browser",
                isSelected = currentScreen == ViewScreen.BROWSER,
                onClick = { onScreenSelected(ViewScreen.BROWSER) }
            )

            // Spacer to push status items to the right (if using SpaceAround, this might not be needed)
            // Spacer(Modifier.weight(1f))

            // Status/Contextual Items (Placeholders for now)
            // Example: Media Controls (very simplified)
            // IconButton(onClick = { /* Play/Pause */ }) {
            //     Icon(Icons.Filled.PlayArrow, contentDescription = "Play/Pause")
            // }
            // IconButton(onClick = { /* Settings */ }) {
            //     Icon(Icons.Filled.Settings, contentDescription = "Settings")
            // }
        }
    }
}

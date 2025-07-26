package com.example.nebula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import com.example.nebula.ui.theme.NebulaTheme
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Apply your TV-specific Material 3 Compose theme here
            NebulaTheme { // This is from androidx.tv.material3
                Surface(
                    // Use androidx.tv.material3.Surface
                    modifier = Modifier.fillMaxSize(),
                    shape = RectangleShape, // TV apps often use RectangleShape
                ) {
                    // This will be replaced by your main launcher composable
                    LauncherHomeScreen()
                }
            }
        }
    }
}

@Composable
fun LauncherHomeScreen() {
    // This is where main TV UI will be built.
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp), // Add some padding around the screen
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Top Area: Perhaps for a greeting or global status (e.g., time/weather preview)
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f) // Small portion of the screen
                .background(Color(0xFF4A148C)) // Purple
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Top Area (e.g., Welcome / Status)",
                style = MaterialTheme.typography.titleMedium,
                color = Color.White
            )
        }

        // Main Content Area: Split into panels
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.8f) // Major portion of the screen
                .padding(vertical = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // Spacing between panels
        ) {
            // Left Panel: App Grid and Favorites/Recent
            Column(
                modifier = Modifier
                    .weight(0.6f) // Takes 60% of the Row's width
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.dp) // Spacing between items in this column
            ) {
                PanelPlaceholder(
                    name = "App Grid Panel",
                    color = Color(0xFF1B5E20), // Dark Green
                    modifier = Modifier.weight(0.7f) // Takes 70% of this Column's height
                )
                PanelPlaceholder(
                    name = "Favorite Apps / Recent Activity Panel",
                    color = Color(0xFF0D47A1), // Dark Blue
                    modifier = Modifier.weight(0.3f) // Takes 30% of this Column's height
                )
            }

            // Right Panel: Browser Tab Management and Widget Area
            Column(
                modifier = Modifier
                    .weight(0.4f) // Takes 40% of the Row's width
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                PanelPlaceholder(
                    name = "Browser Tab Management Panel",
                    color = Color(0xFFBF360C), // Deep Orange
                    modifier = Modifier.weight(0.5f) // Takes 50% of this Column's height
                )
                PanelPlaceholder(
                    name = "Widget Area Panel",
                    color = Color(0xFF006064), // Dark Cyan
                    modifier = Modifier.weight(0.5f) // Takes 50% of this Column's height
                )
            }
        }

        // Bottom Area: Perhaps for hints, navigation tips, or a small banner
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(0.1f) // Small portion of the screen
                .background(Color(0xFF263238)) // Blue Grey
                .padding(8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Bottom Area (e.g., Navigation Hints)",
                style = MaterialTheme.typography.bodySmall,
                color = Color.White
            )
        }
        
//        Text(
//            text = "Welcome to Nebula TV!",
//            style = MaterialTheme.typography.labelLarge,
//            textAlign = TextAlign.Center
//        )
//        AppGrid(modifier = Modifier.weight(1f)) // AppGrid takes available space
        // TODO: Start building your Unified Launcher Home here based on PRD
        // - App grid panel
        // - Favorite apps panel
        // - Browser tab management panel
        // - Widget area
    }
}

@Composable
fun PanelPlaceholder(name: String, color: Color, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .background(color)
            .padding(16.dp), // Padding inside each panel
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = name,
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center,
            color = Color.White // Make text visible on dark backgrounds
        )
    }
}

@Preview(device = "id:tv_1080p") // Use a TV device for preview
@Composable
fun DefaultPreviewOfTVLauncherScreen() {
    // For older tv-material:
    NebulaTheme {
        Surface(modifier = Modifier.fillMaxSize(), shape = RectangleShape) {
            LauncherHomeScreen()
        }
    }
}
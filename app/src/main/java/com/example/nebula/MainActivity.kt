package com.example.nebula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.tv.material3.ExperimentalTvMaterial3Api // Opt-in if needed
import androidx.tv.material3.MaterialTheme // Use M3 Theme
import androidx.tv.material3.Surface
import androidx.tv.material3.Text // Use M3 Text
import com.example.nebula.ui.theme.NebulaTheme
import androidx.compose.ui.text.style.TextAlign
import com.example.nebula.AppGrid

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalTvMaterial3Api::class) // Opt-in for Material 3 TV components
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

@OptIn(ExperimentalTvMaterial3Api::class) // Opt-in for Material 3 TV components
@Composable
fun LauncherHomeScreen() {
    // This is where main TV UI will be built.
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Welcome to Nebula TV!",
            style = MaterialTheme.typography.labelLarge,
            textAlign = TextAlign.Center
        )
        AppGrid(modifier = Modifier.weight(1f)) // AppGrid takes available space
        // TODO: Start building your Unified Launcher Home here based on PRD
        // - App grid panel
        // - Favorite apps panel
        // - Browser tab management panel
        // - Widget area
    }
}

@OptIn(ExperimentalTvMaterial3Api::class) // Opt-in for Material 3 TV components
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
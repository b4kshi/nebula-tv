package com.example.nebula.browser

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.nebula.ui.components.core.PanelView

@Composable
fun BrowserPanel(modifier: Modifier = Modifier) {
    PanelView(name = "Browser Panel", backgroundColor = Color(0xFFBF360C).copy(alpha = 0.7f), modifier = modifier)
}

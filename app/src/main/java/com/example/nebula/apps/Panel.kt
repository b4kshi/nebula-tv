package com.example.nebula.apps

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.nebula.ui.components.core.PanelView

@Composable
fun AppGridPanel(modifier: Modifier = Modifier) {
    PanelView(name = "App Grid Panel", backgroundColor = Color(0xFF0D47A1).copy(alpha = 0.7f), modifier = modifier)
}

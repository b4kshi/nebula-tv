package com.example.nebula.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.nebula.ui.components.core.PanelView

@Composable
fun WidgetAreaPanel(modifier: Modifier = Modifier) {
    PanelView(name = "Widget Area Panel", backgroundColor = Color(0xFF004D40).copy(alpha = 0.7f), modifier = modifier)
}

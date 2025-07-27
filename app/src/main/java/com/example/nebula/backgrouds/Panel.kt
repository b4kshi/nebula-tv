package com.example.nebula.backgrouds

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.nebula.ui.components.core.PanelView

@Composable
fun BackgroundsPanel(modifier: Modifier = Modifier) {
    PanelView(name = "Backgrounds Panel", backgroundColor = Color(0xFFBF360C).copy(alpha = 0.7f), modifier = modifier)
}

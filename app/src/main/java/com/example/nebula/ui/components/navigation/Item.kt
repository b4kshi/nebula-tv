package com.example.nebula.ui.components.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.tv.material3.MaterialTheme
import androidx.tv.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.tv.material3.Card
import androidx.tv.material3.CardDefaults

@Composable
fun NavigationItem(
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    // For TV, focusable items are key. Standard Button or Surface can be made focusable.
    Card ( // Using Surface to better control styling and focus indication for TV
        onClick = onClick,
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 12.dp),
        shape = CardDefaults.shape(CircleShape), // Or RoundedCornerShape(8.dp)
//        colors = CardColors(
//            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.surfaceVariant,
//            contentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
//            focusedContainerColor = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.7f) else Color.Transparent,
//            focusedContentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
//            pressedContainerColor = if (isSelected) MaterialTheme.colorScheme.primary.copy(alpha = 0.5f) else Color.Transparent,
//            pressedContentColor = if (isSelected) MaterialTheme.colorScheme.onPrimary else MaterialTheme.colorScheme.onSurfaceVariant,
//        ),
        scale = CardDefaults.scale(focusedScale = 1.1f) // TV focus effect

    ) {
        Text(text = label, style = MaterialTheme.typography.labelSmall, textAlign = TextAlign.Center)
    }
}

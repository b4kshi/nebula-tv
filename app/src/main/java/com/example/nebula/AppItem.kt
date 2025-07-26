package com.example.nebula

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.*
import androidx.tv.material3.Card // Or other suitable TV container
import androidx.tv.material3.ExperimentalTvMaterial3Api
import androidx.tv.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.graphics.drawable.toBitmap

@OptIn(ExperimentalTvMaterial3Api::class)
@Composable
fun AppItem(appInfo: AppInfo, onAppClick: (AppInfo) -> Unit) {
    Card( // Using Card for a distinct item look
        onClick = { onAppClick(appInfo) },
        modifier = Modifier
            .width(120.dp) // Adjust size as needed
            .height(150.dp)
            .padding(8.dp)
            .focusable(true) // Important for D-pad navigation
    ) {
        Column(
            modifier = Modifier.fillMaxSize().padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            appInfo.icon?.let {
                Image(
                    bitmap = it.toBitmap().asImageBitmap(),
                    contentDescription = appInfo.label,
                    modifier = Modifier.size(64.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = appInfo.label,
                maxLines = 1,
                // style = MaterialTheme.typography.labelSmall // Use TV typography
            )
        }
    }
}
package com.example.nebula

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.isEmpty
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.lazy.grid.GridCells // For TV optimized grid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid // For TV optimized grid
import androidx.compose.foundation.lazy.grid.items // For TV optimized grid

@Composable
fun AppGrid(modifier: Modifier = Modifier, appGridViewModel: AppGridViewModel = viewModel()) {
    val context = LocalContext.current
    val apps by appGridViewModel.apps.collectAsState()

    LaunchedEffect(Unit) { // Use context from LocalContext.current
        appGridViewModel.loadInstalledApps(context)
    }

    if (apps.isEmpty()) {
        // Show a loading indicator or message
        Box(modifier = modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            androidx.tv.material3.Text("Loading apps...")
        }
    } else {
        LazyVerticalGrid(
            columns = GridCells.Fixed(5), // Adjust column count as needed
            modifier = modifier.fillMaxSize().padding(16.dp),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(apps) { app ->
                AppItem(appInfo = app) { clickedApp ->
                    clickedApp.launchIntent?.let {
                        try {
                            context.startActivity(it)
                        } catch (e: Exception) {
                            Toast.makeText(context, "Could not launch ${clickedApp.label}", Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }
}
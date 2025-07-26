package com.example.nebula

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.drawable.Drawable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import android.content.Context // Import Context

data class AppInfo(
    val label: String,
    val packageName: String,
    val icon: Drawable?,
    val launchIntent: Intent?
)

class AppGridViewModel : ViewModel() {
    private val _apps = MutableStateFlow<List<AppInfo>>(emptyList())
    val apps: StateFlow<List<AppInfo>> = _apps

    fun loadInstalledApps(context: Context) { // Pass Context here
        viewModelScope.launch {
            val pm = context.packageManager
            val mainIntent = Intent(Intent.ACTION_MAIN, null).apply {
                addCategory(Intent.CATEGORY_LAUNCHER)
            }
            val resolveInfos = pm.queryIntentActivities(mainIntent, 0)
            val appList = mutableListOf<AppInfo>()
            for (resolveInfo in resolveInfos) {
                val app = AppInfo(
                    label = resolveInfo.loadLabel(pm).toString(),
                    packageName = resolveInfo.activityInfo.packageName,
                    icon = resolveInfo.loadIcon(pm),
                    launchIntent = pm.getLaunchIntentForPackage(resolveInfo.activityInfo.packageName)
                )
                appList.add(app)
            }
            _apps.value = appList.sortedBy { it.label.lowercase() }
        }
    }
}
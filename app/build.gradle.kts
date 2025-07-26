import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
}

android {
    namespace = "com.example.nebula"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.nebula"
        minSdk = 26
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            // To publish on the Play store a private signing key is required, but to allow anyone
            // who clones the code to sign and run the release variant, use the debug signing key.
            // TODO: Abstract the signing configuration to a separate file to avoid hardcoding this.
            signingConfig = signingConfigs.named("debug").get()
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
}

kotlin {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.tv.foundation)
    implementation(libs.androidx.tv.material)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
//    implementation(libs.geckoview)
//    implementation(libs.androidx.browser)
//    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.compose.material3)
//    implementation(libs.androidx.compose.material3.adaptive)
//    implementation(libs.androidx.compose.material3.adaptivelayout)
//    implementation(libs.androidx.compose.material3.adaptivenavigation)
//    implementation(libs.androidx.compose.material3.adaptivenavigationsuite)
//    implementation(libs.androidx.compose.material3.windowsizeclass)
//    implementation(libs.androidx.compose.core.splashscreen)

    // Lifecycle for ViewModels
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    // Other necessary dependencies (Coroutines, etc.)
    implementation(libs.androidx.kotlinx.coroutines)

    androidTestImplementation(libs.hilt.android.testing)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)

    testImplementation(libs.hilt.android.testing)

    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
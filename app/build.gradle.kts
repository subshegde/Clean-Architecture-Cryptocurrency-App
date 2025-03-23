plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("kapt")  // Enable KAPT for annotation processing
}

android {
    namespace = "com.example.cleanarchitecturecryptocurrencyapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.cleanarchitecturecryptocurrencyapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }

    // Enable Jetpack Compose features
    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.3.2" // Use the latest version of Compose
        kotlinCompilerVersion = "1.7.10"  // Use the latest version of Kotlin
    }
}

dependencies {
    // Jetpack Compose Dependencies
    implementation("androidx.compose.ui:ui:1.3.2")  // Core Compose UI
    implementation("androidx.compose.material3:material3:1.0.0") // Material3 UI
    implementation("androidx.compose.ui:ui-tooling-preview:1.3.2") // For UI Preview in Compose
    implementation("androidx.activity:activity-compose:1.6.1")  // Compose support for activities
    implementation("androidx.compose.runtime:runtime-livedata:1.3.2") // LiveData with Compose

    // Hilt Dependencies for Dependency Injection
    implementation("com.google.dagger:hilt-android:2.42")  // Hilt Android Dependency
    kapt("com.google.dagger:hilt-compiler:2.42")  // Hilt Compiler for annotation processing

    // Gson for JSON Parsing
    implementation("com.google.code.gson:gson:2.8.8")

    // Retrofit Dependencies for Networking
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")  // Gson converter for Retrofit

    // Other dependencies for UI and functionality
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    // Enable Hilt support for ViewModels
    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03")  // Hilt lifecycle ViewModel support
}


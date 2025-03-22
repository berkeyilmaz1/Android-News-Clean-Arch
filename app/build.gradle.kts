plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id ("kotlin-parcelize")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.duzceders.newscleanarch"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.duzceders.newscleanarch"
        minSdk = 26
        targetSdk = 35
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
    buildFeatures {
        compose = true
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)

    //Splash Api
    implementation (libs.androidx.core.splashscreen)

    //Compose Navigation

    implementation (libs.androidx.navigation.compose)

    //Dagger Hilt
    implementation (libs.hilt.android)
    ksp (libs.hilt.compiler)
    implementation (libs.androidx.hilt.navigation.compose)


    //Retrofit
    implementation (libs.retrofit)
    implementation (libs.converter.gson)

    //Coil
    implementation(libs.coil.compose)

    //Datastore
    implementation (libs.androidx.datastore.preferences)

    //Compose Foundation
    implementation (libs.androidx.foundation)

    //Accompanist
    implementation (libs.accompanist.systemuicontroller)

    //Paging 3
    implementation (libs.androidx.paging.runtime)
    implementation (libs.androidx.paging.compose)

    //Room
    implementation (libs.androidx.room.runtime)
    ksp (libs.androidx.room.compiler)
    implementation (libs.androidx.room.ktx)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
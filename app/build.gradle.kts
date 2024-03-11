plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.jetbrainsKotlinAndroid)

    id ("com.google.devtools.ksp")

    kotlin("kapt")
    id("com.google.dagger.hilt.android")

}

android {
    namespace = "com.android.tmdbclientpractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.android.tmdbclientpractice"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
        viewBinding= true
        buildConfig = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    val hiltVersion = "2.48"
    val retrofitVersion = "2.9.0"

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)


    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    /*-- Dagger - Hilt --*/
     implementation("com.google.dagger:hilt-android:$hiltVersion")
    ksp("com.google.dagger:hilt-android-compiler:$hiltVersion")

    /*ksp ("com.google.dagger:dagger-compiler:$hiltVersion")
    ksp ("com.google.dagger:hilt-compiler:$hiltVersion") */


    
    /*-- Gson Serialization --*/
    implementation("com.google.code.gson:gson:2.10.1")

    /*-- Compose specific library for navigation & state-management --*/
    implementation ("androidx.hilt:hilt-navigation-compose:1.2.0")
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:2.7.0")
    implementation ("androidx.navigation:navigation-compose:2.7.7")

    /*-- Retrofit ---*/
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

}

// Allow references to generated code
kapt {
    correctErrorTypes = true
}

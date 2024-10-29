plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "io.github.hacker1024.keepongoing"
    compileSdk = 34

    defaultConfig {
        applicationId = "io.github.hacker1024.keepongoing"
        minSdk = 34
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"))
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    compileOnly(libs.xposed.api)
}
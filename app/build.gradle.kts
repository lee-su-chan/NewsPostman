plugins {
    id("com.android.application")
    id("kotlin-android")
}

android {
    defaultConfig {
        applicationId = "com.leesuchan.newspostman"
        versionCode = Version.versionCode
        versionName = Version.versionName
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
}

dependencies {
    implementation(Dep.Android.core)
    implementation(Dep.Android.appcompat)
    implementation(Dep.Android.material)

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
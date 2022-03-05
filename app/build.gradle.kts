plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("androidx.navigation.safeargs.kotlin")
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

    buildFeatures {
        dataBinding = true
    }
}

dependencies {
    implementation(project(":shared"))
    implementation(project(":data"))
    implementation(project(":domain"))
    implementation(project(":features:core-ui"))
    implementation(project(":features:news"))

    implementation(Dep.Android.core)
    implementation(Dep.Android.appcompat)
    implementation(Dep.Android.material)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
    implementation(Dep.Dagger.hiltWorker)
    kapt(Dep.Dagger.hiltWorkerCompiler)

    implementation(Dep.Room.room)
    implementation(Dep.Room.roomKtx)
    kapt(Dep.Room.roomCompiler)

    implementation(Dep.WorkManager.work)

    implementation(Dep.Timber.timber)

    implementation(Dep.Rss.rssParser)

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
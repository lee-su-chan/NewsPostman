plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {
    buildFeatures {
        dataBinding = true
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
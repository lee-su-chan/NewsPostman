plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

}

dependencies {

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
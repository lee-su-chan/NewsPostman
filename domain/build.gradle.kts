plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

}

dependencies {
    implementation(project(":shared"))
    implementation(project(":data"))

    implementation(Dep.Kotlin.coroutine)

    implementation(Dep.Java.inject)

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
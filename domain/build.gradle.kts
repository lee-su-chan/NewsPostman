plugins {
    id("com.android.library")
    id("kotlin-android")
}

android {

}

dependencies {
    implementation(project(":shared"))
    implementation(project(":data"))

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
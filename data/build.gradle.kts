plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {

}

dependencies {
    implementation(Dep.Kotlin.coroutine)

    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
    implementation(Dep.Dagger.hiltWorker)
    kapt(Dep.Dagger.hiltWorkerCompiler)

    implementation(Dep.Room.room)
    implementation(Dep.Room.roomKtx)
    kapt(Dep.Room.roomCompiler)

    implementation(Dep.WorkManager.work)

    implementation(Dep.Rss.rssParser)

    implementation(Dep.Timber.timber)

    testImplementation(Dep.Test.junit)

    androidTestImplementation(Dep.Test.junitExt)
    androidTestImplementation(Dep.Test.espresso)
}
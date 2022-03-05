plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {

}

dependencies {
    implementation(Dep.Dagger.hiltAndroid)
    kapt(Dep.Dagger.hiltCompiler)
    implementation(Dep.Dagger.hiltWorker)
    kapt(Dep.Dagger.hiltWorkerCompiler)

    implementation(Dep.WorkManager.work)

    implementation(Dep.Rss.rssParser)

    implementation(Dep.Timber.timber)
}
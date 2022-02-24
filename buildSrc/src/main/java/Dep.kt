object Version {
    const val compileSdk = 31
    const val minSdk = 23
    const val targetSdk = 31
    const val versionCode = 1
    const val versionName = "1.0.0"
}

object Dep {

    const val androidGradlePlugin = "com.android.tools.build:gradle:7.0.4"

    object Kotlin {
        private const val version = "1.5.31"
        const val gradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$version"
    }

    object Android {
        const val core = "androidx.core:core-ktx:1.7.0"
        const val appcompat = "androidx.appcompat:appcompat:1.4.1"
        const val material = "com.google.android.material:material:1.5.0"
    }

    object Test {
        const val junit = "junit:junit:4.13.2"
        const val junitExt = "androidx.test.ext:junit:1.1.3"
        const val espresso = "androidx.test.espresso:espresso-core:3.4.0"
    }
}
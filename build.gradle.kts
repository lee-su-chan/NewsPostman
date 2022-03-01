// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Dep.androidGradlePlugin)
        classpath(Dep.Kotlin.gradlePlugin)
        classpath(Dep.Dagger.hiltGradlePlugin)
        classpath(Dep.Android.Navigation.safeArgsPlugin)
    }
}

task("clean", Delete::class) {
    delete = setOf(rootProject.buildDir)
}

subprojects {
    afterEvaluate {
        project.apply("$rootDir/gradle/common.gradle")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "NewsPostman"
include(":app")
include(":features:core-ui")
include(":features:news")
include(":data")
include(":domain")

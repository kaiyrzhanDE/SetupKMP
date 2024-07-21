rootProject.name = "SetupKMP"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
    versionCatalogs {
        create("androidLibs") {
            from(files("gradle/androidLibs.versions.toml"))
        }
    }
}

include(":composeApp")

//android features
include(":features-android:navigation")
include(":features-android:something-feature")

//shared features
include(":features-shared:navigation")
include(":features-shared:somethingFeature")
include(":features-shared:di")

//shared core
include(":core-shared:network")
include(":core-shared:utils")
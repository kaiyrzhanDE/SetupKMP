import app.androidApp

plugins {
    id("android.app")
}

kotlin {
    sourceSets {
        commonMain.dependencies {
            implementation(projects.featuresAndroid.navigation)
            implementation(projects.featuresShared.di)
            implementation(projects.coreShared.utils)
        }
    }
}


android{
    namespace = "${androidApp.namespace}.android"
    defaultConfig{
        applicationId = "${androidApp.namespace}.android"
    }
}


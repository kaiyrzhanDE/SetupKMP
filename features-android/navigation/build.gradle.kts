import app.androidApp

plugins {
    id("android.presentation")
}

android {
    namespace = "${androidApp.namespace}.android.root"
    dependencies {
        api(projects.featuresShared.navigation)
        implementation(projects.featuresAndroid.somethingFeature)
    }
}
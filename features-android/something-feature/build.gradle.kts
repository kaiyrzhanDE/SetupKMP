import app.androidApp

plugins{
    id("android.presentation")
}

android{
    namespace = "${androidApp.namespace}.android.somethingFeature"
    dependencies{
        implementation(projects.featuresShared.somethingFeature)
    }
}


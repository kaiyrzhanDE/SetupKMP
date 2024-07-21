import app.androidApp

plugins{
    id("multiplatform.navigation")
}

kotlin{
    sourceSets.commonMain.dependencies {
        api(projects.featuresShared.somethingFeature)
    }
}

android{
    namespace = "${androidApp.namespace}.features.root"
}
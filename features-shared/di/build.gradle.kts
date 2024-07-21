import app.androidApp

plugins{
    id("multiplatform.app")
}

kotlin{
    sourceSets{
        commonMain.dependencies {
            implementation(projects.coreShared.utils)
            implementation(projects.coreShared.network)
            implementation(projects.featuresShared.somethingFeature)
        }
    }
}

android{
    namespace = "${androidApp.namespace}.core.di"
}
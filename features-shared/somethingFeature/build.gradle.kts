import app.androidApp

plugins{
    id("multiplatform.app")
}

kotlin{
    sourceSets.commonMain.dependencies {
        implementation(projects.coreShared.utils)
    }
}
android{
    namespace = "${androidApp.namespace}.features.first"
}
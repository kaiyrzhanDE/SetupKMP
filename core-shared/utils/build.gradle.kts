import app.androidApp

plugins{
    id("multiplatform.utils")
}

android{
    namespace = "${androidApp.namespace}.core.utils"
}
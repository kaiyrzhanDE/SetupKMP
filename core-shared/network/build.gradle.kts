import app.androidApp
import com.codingfeline.buildkonfig.compiler.FieldSpec
import config.BuildKonfig

plugins{
    id("multiplatform.network")
}

android{
    namespace = "${androidApp.namespace}.core.network"
}

kotlin{
    sourceSets.commonMain.dependencies {
        implementation(projects.coreShared.utils)
    }
}

buildkonfig{
    packageName = BuildKonfig.Key.PACKAGE_NAME
    objectName = BuildKonfig.Key.OBJECT_NAME
    exposeObjectWithName = BuildKonfig.Key.EXPOSE_OBJECT_NAME

    defaultConfigs {
        buildConfigField(
            FieldSpec.Type.STRING,
            BuildKonfig.Key.BASE_URL,
            BuildKonfig.Release.BASE_URL,
        )
    }

    defaultConfigs(BuildKonfig.Release.NAME){
        buildConfigField(
            FieldSpec.Type.STRING,
            BuildKonfig.Key.BASE_URL,
            BuildKonfig.Release.BASE_URL,
        )
    }
    defaultConfigs(BuildKonfig.Debug.NAME){
        buildConfigField(
            FieldSpec.Type.STRING,
            BuildKonfig.Key.BASE_URL,
            BuildKonfig.Debug.BASE_URL,
        )
    }
}
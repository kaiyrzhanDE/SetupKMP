import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "kaiyrzhan.de.sample"
dependencies {
    compileOnly(androidLibs.compose.gradle.plugin)
    implementation(androidLibs.android.gradle.plugin)
    implementation(libs.kotlin.gradle.plugin)
    implementation(libs.buildkonfig.gradle.plugin)
    implementation(libs.ktorfit.gradle.plugin)
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_11.toString()
    }
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

gradlePlugin {
    plugins {
        register("android.app") {
            id = "android.app"
            implementationClass = "plugin.AndroidAppPlugin"
        }
        register("android.presentation") {
            id = "android.presentation"
            implementationClass = "plugin.AndroidPresentationPlugin"
        }
        register("multiplatform.app"){
            id = "multiplatform.app"
            implementationClass = "plugin.MultiplatformAppPlugin"
        }
        register("multiplatform.navigation"){
            id = "multiplatform.navigation"
            implementationClass = "plugin.MultiplatformNavigationPlugin"
        }
        register("multiplatform.network"){
            id = "multiplatform.network"
            implementationClass = "plugin.MultiplatformNetworkPlugin"
        }
        register("multiplatform.utils"){
            id = "multiplatform.utils"
            implementationClass = "plugin.MultiplatformUtilsPlugin"
        }
    }
}

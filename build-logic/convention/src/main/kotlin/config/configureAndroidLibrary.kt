package config

import com.android.build.gradle.LibraryExtension
import app.androidApp
import core.androidLibs
import org.gradle.api.Project

internal fun Project.configureAndroidLibrary(
    extension: LibraryExtension,
) = extension.apply {
    compileSdk = androidLibs.findVersion(core.AndroidLibs.COMPILE_SDK).get().requiredVersion.toInt()
    defaultConfig.apply {
        minSdk = androidLibs.findVersion(core.AndroidLibs.MIN_SDK).get().requiredVersion.toInt()
    }
    packaging.resources.excludes += "/META-INF/{AL2.0,LGPL2.1}"
    compileOptions {
        sourceCompatibility = androidApp.javaVersion
        targetCompatibility = androidApp.javaVersion
    }
}

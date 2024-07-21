package app

import org.gradle.api.JavaVersion

data class AndroidApp(
    val namespace: String = "kaiyrzhan.de",
    val versionCode: Int = 1,
    val versionName: String = "1.0",
    val javaVersion: JavaVersion = JavaVersion.VERSION_11,
)

val androidApp by lazy { AndroidApp() }


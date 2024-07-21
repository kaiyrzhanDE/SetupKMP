package config

import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinMultiplatformExtension
import org.jetbrains.kotlin.gradle.plugin.mpp.Framework

internal fun Project.configureIOSFramework(
    extension: KotlinMultiplatformExtension,
    targetBinariesFramework: (Framework.() -> Unit)? = null,
) = with(extension) {
    val sharedName = "Shared${project.name.titleCase()}"
    println("sharedName: $sharedName")
    listOf(iosX64(), iosArm64(), iosSimulatorArm64()).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = sharedName
            targetBinariesFramework?.let {
                targetBinariesFramework()
            }
        }
    }
}

private fun String.titleCase() = this.replaceFirstChar { it.uppercase() }
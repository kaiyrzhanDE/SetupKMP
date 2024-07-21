package app

internal data class IOSApp(
    val namespace: String = "kaiyrzhan.de.setup"
)

internal val iosApp by lazy { IOSApp() }

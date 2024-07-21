package kaiyrzhan.de.sample

import android.app.Application
import di.androidModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class TurbinatorApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@TurbinatorApp)
            modules(androidModules())
        }
    }
}
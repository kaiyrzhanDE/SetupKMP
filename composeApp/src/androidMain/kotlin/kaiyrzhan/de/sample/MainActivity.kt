package kaiyrzhan.de.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.arkivanov.decompose.defaultComponentContext
import org.koin.core.component.KoinComponent
import root.RealRootComponent
import root.RootContent

class MainActivity : ComponentActivity(), KoinComponent {
    private val rootComponent by lazy { RealRootComponent(defaultComponentContext()) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RootContent(component = rootComponent)
        }
    }
}

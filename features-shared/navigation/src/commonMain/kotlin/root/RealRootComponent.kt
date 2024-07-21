package root

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.value.Value
import kotlinx.serialization.Serializable
import main.MainComponent
import main.RealMainComponent

class RealRootComponent(
    componentContext: ComponentContext,
) : ComponentContext by componentContext, RootComponent {

    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, RootComponent.Child>> = childStack(
        source = navigation,
        serializer = Config.serializer(),
        initialConfiguration = Config.Main,
        handleBackButton = true,
        childFactory = ::child
    )

    override fun onBackPressed() = navigation.pop()

    private fun child(config: Config, childComponentContext: ComponentContext) =
        when (config) {
            Config.Main -> RootComponent.Child.Main(
                component = mainComponent(childComponentContext),
            )
        }

    private fun mainComponent(componentContext: ComponentContext): MainComponent =
        RealMainComponent(
            componentContext = componentContext,
            onBackChosen = ::onBackPressed
        )

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Main : Config
    }
}
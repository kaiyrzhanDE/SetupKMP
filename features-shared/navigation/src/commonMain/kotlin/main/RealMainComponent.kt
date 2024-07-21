package main

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.value.Value
import navigation.detail.FeatureDetailComponent
import navigation.detail.RealFeatureDetailComponent
import kotlinx.serialization.Serializable
import navigation.feature.FeatureComponent
import navigation.feature.RealFeatureComponent

class RealMainComponent(
    componentContext: ComponentContext,
    private val onBackChosen: () -> Unit,
) : ComponentContext by componentContext, MainComponent {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, MainComponent.Child>> =
        childStack(
            source = navigation,
            serializer = Config.serializer(),
            initialConfiguration = Config.Feature,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(
        config: Config,
        childComponentContext: ComponentContext
    ): MainComponent.Child =
        when (config) {
            is Config.Feature -> MainComponent.Child.Feature(
                component = realFeatureComponent(childComponentContext)
            )

            is Config.FeatureDetail -> MainComponent.Child.FeatureDetail(
                component = realFeatureDetailComponent(childComponentContext)
            )
        }

    private fun realFeatureComponent(componentContext: ComponentContext): FeatureComponent =
        RealFeatureComponent(
            componentContext = componentContext,
            onBackChosen = ::onBackClicked,
            onMapDetailChosen = { TODO() },
        )

    private fun realFeatureDetailComponent(componentContext: ComponentContext): FeatureDetailComponent =
        RealFeatureDetailComponent(
            componentContext = componentContext,
            onBackChosen = ::onBackClicked,
        )

    override fun onBackClicked() = onBackChosen()

    @Serializable
    private sealed interface Config {
        @Serializable
        data object Feature : Config

        @Serializable
        data object FeatureDetail : Config
    }
}
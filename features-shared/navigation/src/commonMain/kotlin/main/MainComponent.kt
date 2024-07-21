package main

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import navigation.detail.FeatureDetailComponent
import navigation.feature.FeatureComponent

interface MainComponent : BackHandlerOwner {

    val stack: Value<ChildStack<*, Child>>

    fun onBackClicked()

    sealed interface Child {
        data class Feature(val component: FeatureComponent) : Child
        data class FeatureDetail(val component: FeatureDetailComponent) : Child
    }
}
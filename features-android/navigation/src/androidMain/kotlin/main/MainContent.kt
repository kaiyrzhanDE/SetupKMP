package main

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.arkivanov.decompose.extensions.compose.stack.Children
import com.arkivanov.decompose.extensions.compose.stack.animation.fade
import com.arkivanov.decompose.extensions.compose.stack.animation.plus
import com.arkivanov.decompose.extensions.compose.stack.animation.scale
import com.arkivanov.decompose.extensions.compose.stack.animation.stackAnimation
import map.FeatureContent
import detail.FeatureDetailContent

@Composable
internal fun MainContent(
    component: MainComponent,
    modifier: Modifier = Modifier,
) {
    Surface(
        modifier = modifier.fillMaxSize(),
    ) {
        Children(
            stack = component.stack,
            animation = stackAnimation(scale() + fade()),
        ) {
            when(val instance = it.instance){
                is MainComponent.Child.Feature -> FeatureContent(component = instance.component)
                is MainComponent.Child.FeatureDetail -> FeatureDetailContent(component = instance.component)
            }
        }
    }
}
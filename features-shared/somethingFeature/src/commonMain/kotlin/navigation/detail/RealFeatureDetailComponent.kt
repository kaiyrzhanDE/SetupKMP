package navigation.detail

import com.arkivanov.decompose.ComponentContext

class RealFeatureDetailComponent(
    componentContext: ComponentContext,
    private val onBackChosen: () -> Unit,
) : ComponentContext by componentContext, FeatureDetailComponent {

    override fun onBackPressed() = onBackChosen()

}
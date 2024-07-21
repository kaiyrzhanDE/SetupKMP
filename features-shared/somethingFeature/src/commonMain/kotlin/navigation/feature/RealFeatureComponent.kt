package navigation.feature

import com.arkivanov.decompose.ComponentContext
import dispatchers.AppDispatchers
import kotlinx.coroutines.CoroutineScope
import logger.Logger
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class RealFeatureComponent(
    private val componentContext: ComponentContext,
    private val onBackChosen: () -> Unit,
    private val onMapDetailChosen: (id: String) -> Unit,
) : ComponentContext by componentContext, FeatureComponent, KoinComponent {
    private val logger: Logger by inject()
    private val appDispatchers: AppDispatchers by inject()

    private val scope = CoroutineScope(appDispatchers.io)

    init {
        logger.d("RealMapComponent", "init")
    }

    override fun onBackPressed() = onBackChosen()

    override fun onDetailClicked(id: String) = onMapDetailChosen(id)

}
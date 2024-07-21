package root

import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.value.Value
import com.arkivanov.essenty.backhandler.BackHandlerOwner
import main.MainComponent

interface RootComponent: BackHandlerOwner {

    val stack: Value<ChildStack<*, Child>>

    fun onBackPressed()

    sealed interface Child{
        data class Main(val component: MainComponent): Child
    }
}
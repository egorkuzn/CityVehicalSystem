import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.nsu.fit.g20204.egorkuzn.client.view.navcontroller.NavController
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.AbstractScreen
import ru.nsu.fit.g20204.egorkuzn.client.view.screens.MenuScreen

object AppViewDesktop {
    /**
     * Имеются некоторые экраны, между которыми мы переключаемся
     */
    private val screens = AbstractScreen.screensList

    /**
     * Здесь задается начальное значение контроллера, который занимается навигацией.
     * Начальный экран - это меню, в котором происходит выбор таблицы.
     */
    private val navController by mutableStateOf(NavController(MenuScreen, mutableSetOf()))
    private val currentScreen by navController.currentScreen

    @Composable
    @Preview
    fun render() {
        MaterialTheme {
            Surface(
                modifier = Modifier.background(color = MaterialTheme.colors.background)
            ) {
                Box(
                    modifier = Modifier.fillMaxSize()
                ) {
                    Box(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        CustomNavigationHost(navController = navController)
                    }
                }
            }
        }
    }


    /**
     * Screens
     */
    @Composable
    fun CustomNavigationHost(
        navController: NavController
    ) {
        navController.currentScreen.value.render(navController)
    }
}
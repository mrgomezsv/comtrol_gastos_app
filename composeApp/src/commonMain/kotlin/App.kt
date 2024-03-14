import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Apps
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import data.TItleTopBarTypes
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.navigation.rememberNavigator

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()

        AppTheme {
            val navigator = rememberNavigator()
            val titleTopBar = getTitleTopAppBar(navigator)
            val isEditOrAddExpenses = titleTopBar != TItleTopBarTypes.DASHBOARD.value

            Scaffold(
                modifier = Modifier.fillMaxSize(),
                topBar = {
                    TopAppBar(
                        elevation = 0.dp,
                        title = {
                            Text(
                                text = titleTopBar,
                                fontSize = 25.sp,
                                color = colors.textColor
                            )
                        },
                        navigationIcon = {
                            if (isEditOrAddExpenses) {
                                IconButton(
                                    onClick = {
                                        navigator.popBackStack()
                                    }
                                ) {
                                    Icon(
                                        modifier = Modifier.padding(start = 16.dp),
                                        imageVector = Icons.Default.ArrowBack,
                                        tint = colors.textColor,
                                        contentDescription = "Flecha back icon"
                                    )
                                }
                            } else {
                                Icon(
                                    modifier = Modifier.padding(start = 16.dp),
                                    imageVector = Icons.Default.Apps,
                                    tint = colors.textColor,
                                    contentDescription = "Dashboard icon"
                                )
                            }
                        },
                        backgroundColor = colors.backgroundColor,
                    )
                }
            ) {

            }
        }
    }
}

@Composable
fun getTitleTopAppBar(navigator: Navigator): String {
    var titleTopBar = TItleTopBarTypes.DASHBOARD

    val isOnAddExpenses =
        navigator.currentEntry.collectAsState(null).value?.route?.route.equals("/addExpenses/{id}")
    if (isOnAddExpenses) {
        titleTopBar = TItleTopBarTypes.ADD
    }

    val isOnEditExpenses = navigator.currentEntry.collectAsState(null).value?.path<Long>("id")
    isOnEditExpenses?.let {
        titleTopBar = TItleTopBarTypes.EDIT
    }

    return titleTopBar.value
}
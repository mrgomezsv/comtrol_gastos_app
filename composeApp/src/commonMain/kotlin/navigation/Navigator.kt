package navigation

import androidx.compose.foundation.background
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import data.ExpenseManager
import data.ExpenseRepoImpl
import getColorsTheme
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.navigation.NavHost
import moe.tlaster.precompose.navigation.Navigator
import moe.tlaster.precompose.navigation.path
import moe.tlaster.precompose.viewmodel.viewModel
import presentacion.ExpensesViewModel
import ui.ExpensesScreen

@Composable
fun Navitation(navigator: Navigator) {

    val colors = getColorsTheme()
    val viewModel = viewModel(modelClass = ExpensesViewModel::class) {
        ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
    }

    NavHost(
        modifier = Modifier.background(colors.backgroundColor),
        navigator = navigator,
        initialRoute = "/home"
    ) {
        scene(route = "/home") {
            val uiState by viewModel.uiState.collectAsStateWithLifecycle()
            ExpensesScreen(uiState) { expense ->
                navigator.navigate("/adddExpenses/${expense.id}")
            }
        }

        scene(route = "/addExpenses/{id}") {backStackEntry ->
            val idFromPath = backStackEntry.path<Long>("id")
            //val idFromPath = it
            val isAddExpense = idFromPath?.let { id -> viewModel.getExpenseWithID(id) }

            //Crear expensesDetailScreen

        }
    }
}

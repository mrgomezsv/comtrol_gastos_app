import androidx.compose.runtime.*
import data.ExpenseManager
import data.ExpenseRepoImpl
import moe.tlaster.precompose.PreComposeApp
import moe.tlaster.precompose.flow.collectAsStateWithLifecycle
import moe.tlaster.precompose.viewmodel.viewModel
import presentacion.ExpensesViewModel
import ui.ExpensesScreen

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()
        val viewModel = viewModel(modelClass = ExpensesViewModel::class) {
            ExpensesViewModel(ExpenseRepoImpl(ExpenseManager))
        }

        val uiState by viewModel.uiState.collectAsStateWithLifecycle()

        AppTheme {
            ExpensesScreen(
                uiState = uiState, onExpenseClick = {})

        }
    }
}
import androidx.compose.runtime.*
import data.ExpenseManager
import moe.tlaster.precompose.PreComposeApp
import presentacion.ExpensesUiState
import ui.ExpensesScreen

@Composable
fun App() {
    PreComposeApp {

        val colors = getColorsTheme()

        AppTheme {
            ExpensesScreen(
                uiState = ExpensesUiState(
                    expenses = ExpenseManager.fakeExpenseList,
                    total = 1052.2
                ), onExpenseClick = {})

        }
    }
}
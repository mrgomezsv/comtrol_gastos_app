package presentacion

import domain.ExpenseResitory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import model.Expense
import model.ExpenseCategory
import moe.tlaster.precompose.viewmodel.ViewModel
import moe.tlaster.precompose.viewmodel.viewModelScope

data class ExpensesUiState(
    val expenses: List<Expense> = emptyList(),
    val total: Double = 0.0
)

 class ExpensesViewModel(private val repo: ExpenseResitory) : ViewModel() {

     private val _uiState = MutableStateFlow(ExpensesUiState())
     val uiState = _uiState.asStateFlow()
     private val alLExpense = repo.getAllExpenses()

     init {
         getAllExpenses()

     }

     private fun getAllExpenses() {
         viewModelScope.launch {
             updateState()
         }
     }

     fun addExpense(expense: Expense) {
         viewModelScope.launch {
             repo.addExpense(expense)
             updateState()
         }
     }

     fun editExpense(expense: Expense) {
         viewModelScope.launch {
             repo.editExpense(expense)
             updateState()
         }
     }

//     fun deleteExpense(expense: Expense) {
//         viewModelScope.launch {
//             repo.deleteExpense(expense)
//             updateState()
//         }
//     }

     private fun updateState() {
         _uiState.update { state ->
             state.copy(expenses = alLExpense, total = alLExpense.sumOf { it.amount })
         }
     }

     fun getExpenseWithID(id: Long): Expense {
         return alLExpense.first{ it.id ==id }
     }

     fun getCategories(): List<ExpenseCategory> {
         return repo.getCategories()
     }
}
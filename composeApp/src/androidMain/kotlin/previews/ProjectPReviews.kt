package previews

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import model.Expense
import model.ExpenseCategory
import ui.AllExpensesHeader
import ui.ExpensesItem
import ui.ExpensesTotalHeader

@Preview()
@Composable
fun ExpensesTotalHeaderPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        ExpensesTotalHeader(total = 1028.8)
    }
}

@Preview(showBackground = true)
@Composable
fun AllExpensesPreview() {
    Box(modifier = Modifier.padding(16.dp)) {
        AllExpensesHeader()
    }
}

@Preview()
@Composable
fun ExpensesItemPreview() {
    Box(modifier = Modifier.padding(8.dp)) {
        ExpensesItem(expense = Expense(
            id = 1L,
            amount = 70.0,
            category = ExpenseCategory.PARTY,
            description = "Fin de semana"
        ), onExpenseClick = {})
    }
}
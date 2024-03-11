package data

import domain.ExpenseResitory
import model.Expense
import model.ExpenseCategory

class ExpenseRepoImpl: ExpenseResitory {
    override fun getAllExpenses(): List<Expense> {
        return ExpenseManager.fakeExpenseList
    }

    override fun addExpense(expense: Expense) {
        ExpenseManager.addNewExpense(expense)
    }

    override fun editExpense(expense: Expense) {
        ExpenseManager.editExpense(expense)
    }

    override fun getCategories(): List<ExpenseCategory> {
        return ExpenseManager.getCategories()
    }
}
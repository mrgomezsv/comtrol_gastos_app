package data

import model.Expense
import model.ExpenseCategory

object ExpenseManager {

    private var currentId = 1L

    var fakeExpenseList = mutableListOf( //datos fake de ejemplo
        Expense(
            id = currentId++,
            amount = 100.0,
            category = ExpenseCategory.CHUCHERIAS,
            description = "Semanal"
        ),

        Expense(
            id = currentId++,
            amount = 33.87,
            category = ExpenseCategory.CAFÉ,
            description = "Mensual"
        ),

        Expense(
            id = currentId++,
            amount = 10.2,
            category = ExpenseCategory.SNACKS,
            description = "Boquitas"
        ),

        Expense(
            id = currentId++,
            amount = 21000.0,
            category = ExpenseCategory.TRANSPORTE,
            description = "Pasaje Urbano"
        ),

        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.DIVERSION,
            description = "Fin de Semana"
        ),

        Expense(
            id = currentId++,
            amount = 25.0,
            category = ExpenseCategory.HOUSE,
            description = "Limpieza"
        ),

        Expense(
            id = currentId++,
            amount = 120.0,
            category = ExpenseCategory.OTROS,
            description = "Servicios"
        )
    )

    fun addNewExpense(expense: Expense) {
        fakeExpenseList.add(expense.copy(id = currentId++))
    }

    fun editExpense(expense: Expense) {
        val index = fakeExpenseList.indexOfFirst {
            it.id == expense.id
        }
        if(index != -1) {
            fakeExpenseList[index] = fakeExpenseList[index].copy(
                amount = expense.amount,
                category = expense.category,
                description = expense.description
            )
        }
    }

//    fun deleteExpense(expense: Expense) {
//        val index = fakeExpenseList.indexOfFirst {
//            it.id == expense.id
//        }
//        fakeExpenseList.removeAt(index)
//    }

    fun getCategories(): List<ExpenseCategory> {
        return listOf(
            ExpenseCategory.CAFÉ,
            ExpenseCategory.TRANSPORTE,
            ExpenseCategory.CHUCHERIAS,
            ExpenseCategory.SNACKS,
            ExpenseCategory.DIVERSION,
            ExpenseCategory.HOUSE,
            ExpenseCategory.OTROS
        )
    }
}
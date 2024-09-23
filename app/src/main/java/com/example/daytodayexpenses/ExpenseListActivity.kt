package com.example.daytodayexpenses

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ExpenseListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_list)

        val recyclerView = findViewById<RecyclerView>(R.id.expenseRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val expensesAdapter = ExpensesAdapter(getExpenses())
        recyclerView.adapter = expensesAdapter

        val addExpenseButton = findViewById<Button>(R.id.addExpenseButton)
        addExpenseButton.setOnClickListener {
            val intent = Intent(this, AddExpenseActivity::class.java)
            startActivity(intent)
        }
    }

    private fun getExpenses(): List<Expense> {
        // Mock data or fetch from a database
        return listOf(
            Expense(1, "Lunch", 10.0, "2024-08-23"),
            Expense(2, "Transport", 5.0, "2024-08-22")
        )
    }
}

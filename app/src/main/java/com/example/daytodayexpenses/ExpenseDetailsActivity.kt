package com.example.daytodayexpenses

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ExpenseDetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_expense_details)

        val amountTextView = findViewById<TextView>(R.id.amount)
        val dateTextView = findViewById<TextView>(R.id.date)
        val categoryTextView = findViewById<TextView>(R.id.category)
        val descriptionTextView = findViewById<TextView>(R.id.description)

        // Load expense details here (mock data for now)
        amountTextView.text = "100"
        dateTextView.text = "2024-08-23"
        categoryTextView.text = "Food"
        descriptionTextView.text = "Dinner"
    }
}

package com.example.daytodayexpenses

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class EditExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_expense)

        val amountEditText = findViewById<EditText>(R.id.amount)
        val dateEditText = findViewById<EditText>(R.id.date)
        val categoryEditText = findViewById<EditText>(R.id.category)
        val descriptionEditText = findViewById<EditText>(R.id.description)
        val saveButton = findViewById<Button>(R.id.saveButton)
        val deleteButton = findViewById<Button>(R.id.deleteButton)

        // Load the expense details here (mock data for now)
        amountEditText.setText("100")
        dateEditText.setText("2024-08-23")
        categoryEditText.setText("Food")
        descriptionEditText.setText("Dinner")

        saveButton.setOnClickListener {
            val amount = amountEditText.text.toString()
            val date = dateEditText.text.toString()
            val category = categoryEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (amount.isNotEmpty() && date.isNotEmpty() && category.isNotEmpty()) {
                // Save expense logic here
                Toast.makeText(this, "Expense updated", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        deleteButton.setOnClickListener {
            // Delete expense logic here
            Toast.makeText(this, "Expense deleted", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}

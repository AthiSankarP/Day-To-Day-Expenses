package com.example.daytodayexpenses

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AddExpenseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_expense)

        val amountEditText = findViewById<EditText>(R.id.amount)
        val dateEditText = findViewById<EditText>(R.id.date)
        val categoryEditText = findViewById<EditText>(R.id.category)
        val descriptionEditText = findViewById<EditText>(R.id.description)
        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val amount = amountEditText.text.toString()
            val date = dateEditText.text.toString()
            val category = categoryEditText.text.toString()
            val description = descriptionEditText.text.toString()

            if (amount.isNotEmpty() && date.isNotEmpty() && category.isNotEmpty()) {
                // Save expense logic here
                Toast.makeText(this, "Expense added", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

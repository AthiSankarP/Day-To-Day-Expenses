package com.example.daytodayexpenses

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class DashboardActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val viewExpensesButton = findViewById<Button>(R.id.viewExpensesButton)
        viewExpensesButton.setOnClickListener {
            val intent = Intent(this, ExpenseListActivity::class.java)
            startActivity(intent)
        }

        // Add other buttons and logic for other functionalities
    }
}

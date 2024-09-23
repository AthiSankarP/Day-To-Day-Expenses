package com.example.daytodayexpenses

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.daytodayexpenses.ui.theme.DayToDayExpensesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DayToDayExpensesTheme {
                // A surface container using the background color from the theme
                Surface(color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    MyAppNavHost(navController)
                }
            }
        }
    }
}

@Composable
fun MyAppNavHost(navController: NavHostController) {
    NavHost(navController, startDestination = "main") {
        composable("main") { MainScreen(navController) }
        composable("addTransaction") { AddTransactionScreen() }
        composable("viewTransactions") { ViewTransactionsScreen() }
        composable("viewReports") { ViewReportsScreen() }
    }
}

@Composable
fun MainScreen(navController: NavHostController) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = { navController.navigate("addTransaction") },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("Add Transaction")
                }

                Button(
                    onClick = { navController.navigate("viewTransactions") },
                    modifier = Modifier.padding(bottom = 16.dp)
                ) {
                    Text("View Transactions")
                }

                Button(
                    onClick = { navController.navigate("viewReports") }
                ) {
                    Text("View Reports")
                }
            }
        }
    )
}

@Composable
fun AddTransactionScreen() {
    // Implement your Add Transaction UI here
    Scaffold(
        topBar = { Text("Add Transaction") },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Your UI components for Add Transaction
                Text("This is the Add Transaction Screen")
            }
        }
    )
}

@Composable
fun ViewTransactionsScreen() {
    // Implement your View Transactions UI here
    Scaffold(
        topBar = { Text("View Transactions") },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Your UI components for View Transactions
                Text("This is the View Transactions Screen")
            }
        }
    )
}

@Composable
fun ViewReportsScreen() {
    // Implement your View Reports UI here
    Scaffold(
        topBar = { Text("View Reports") },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                // Your UI components for View Reports
                Text("This is the View Reports Screen")
            }
        }
    )
}

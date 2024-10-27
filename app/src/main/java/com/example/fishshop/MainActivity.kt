package com.example.fishshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.fishshop.ui.theme.MyApplicationTheme
import com.example.fishshop.button.BottomNavigationBar
import com.example.fishshop.screen.BasketScreen
import com.example.fishshop.screen.ChatScreen
import com.example.fishshop.screen.HomeScreen
import com.example.fishshop.screen.InfoScreen
import com.example.fishshop.screen.ProfileScreen
import com.example.fishshop.toolbar.CustomToolbar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = {
            CustomToolbar(
                onProfileClick = { navController.navigate("profile") },
                onSearchClick = { /* Handle search click */ }
            )
        },
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) {
        NavHost(navController, startDestination = "home") {
            composable("home") { HomeScreen() }
            composable("basket") { BasketScreen() }
            composable("chat") { ChatScreen() }
            composable("info") { InfoScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

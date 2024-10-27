package com.example.fishshop.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OrderCompleteScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Спасибо за заказ!",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Ожидайте звонка.",
            fontSize = 18.sp,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.popBackStack("home", inclusive = false) },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Вернуться на главную")
        }
    }
}

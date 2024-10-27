package com.example.fishshop.basket

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun OrderAddressScreen(navController: NavController) {
    var address by remember { mutableStateOf("") }
    var comment by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Заполните адрес",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = address,
            onValueChange = { address = it },
            label = { Text("Подробный адрес") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = comment,
            onValueChange = { comment = it },
            label = { Text("Комментарии к заказу") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = { navController.navigate("contact_number") },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Завершить заказ")
        }
    }
}

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
fun ContactNumberScreen(navController: NavController) {
    var contactNumber by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Введите номер телефона",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(32.dp))

        TextField(
            value = contactNumber,
            onValueChange = {
                contactNumber = it
                errorMessage = ""
            },
            label = { Text("Номер телефона (начиная с +7)") },
            isError = errorMessage.isNotEmpty(),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMessage.isNotEmpty()) {
            Text(
                text = errorMessage,
                color = Color.Red,
                fontSize = 12.sp,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        Button(
            onClick = {
                if (isValidPhoneNumber(contactNumber)) {
                    navController.navigate("order_complete")
                } else {
                    errorMessage = "Пожалуйста, введите корректный номер телефона, начинающийся с +7."
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Подтвердить")
        }
    }
}

private fun isValidPhoneNumber(phoneNumber: String): Boolean {
    return phoneNumber.startsWith("+7") && phoneNumber.substring(2).all { it.isDigit() }
}

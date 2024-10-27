package com.example.fishshop.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@Composable
fun UserProfileScreen(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(
                text = "Личная информация",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = "ФИО: Иванов Иван Иванович")
            Text(text = "Email: example@mail.com")
            Text(text = "Телефон: +7 123 456 7890")
            Text(text = "Дата рождения: 01.01.2000")
            Text(text = "Пол: Мужской")
            Button(
                onClick = { /* Handle edit personal info */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Изменить личную информацию")
            }
        }

        item {
            Text(
                text = "Адреса доставки",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Временные данные для отображения
            DeliveryAddressList()
            Button(
                onClick = { /* Handle add address */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Добавить адрес")
            }
        }

        item {
            Text(
                text = "Заказы",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            // Временные данные для отображения
            OrderHistoryList()
            Button(
                onClick = { /* Handle repeat order */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Повторить заказ")
            }
        }

        item {
            Text(
                text = "Оплата и счета",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Text(text = "Способы оплаты: Картой, Наличные")
            Text(text = "История платежей")
        }

        item {
            Text(
                text = "Безопасность",
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(bottom = 8.dp)
            )
            Button(
                onClick = { /* Handle change password */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Изменить пароль")
            }
            Button(
                onClick = { /* Handle logout */ },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(text = "Выйти из аккаунта")
            }
        }
    }
}

@Composable
fun DeliveryAddressList() {
    // Временные данные для отображения
    val addresses = listOf(
        "Адрес 1: улица Пушкина, дом Колотушкина",
        "Адрес 2: улица Ленина, дом 5",
        "Адрес 3: улица Гагарина, дом 12"
    )

    addresses.forEach { address ->
        Text(text = address, modifier = Modifier.padding(vertical = 4.dp))
    }
}

@Composable
fun OrderHistoryList() {
    // Временные данные для отображения
    val orders = listOf(
        "Заказ 1: 01.01.2023",
        "Заказ 2: 15.01.2023",
        "Заказ 3: 20.01.2023"
    )

    orders.forEach { order ->
        Text(text = order, modifier = Modifier.padding(vertical = 4.dp))
    }
}

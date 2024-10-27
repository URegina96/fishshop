package com.example.fishshop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fishshop.basket.BasketItem
import com.example.fishshop.basket.BasketItemRow

@Composable
fun BasketScreen(
    navController: NavController,
    basketItems: SnapshotStateList<BasketItem>,
    totalPrice: Double,
    onRemove: (BasketItem) -> Unit,
    onIncrease: (BasketItem) -> Unit,
    onDecrease: (BasketItem) -> Unit
) {
    Column(
        modifier = Modifier
            .background(Color(0xFFFFFFE0))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(basketItems) { basketItem ->
                BasketItemRow(
                    basketItem = basketItem,
                    onRemove = onRemove,
                    onIncrease = onIncrease,
                    onDecrease = onDecrease
                )
            }
        }
        Text(
            text = "Тут какой-то текст информационный",
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Text(
            text = "Итого: $totalPrice руб.",
            fontSize = 18.sp,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        Button(
            onClick = {
                if (basketItems.isEmpty()) {
                    // Показать сообщение, что корзина пуста
                } else {
                    navController.navigate("order_address") // Заменить на правильный маршрут
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Оформить")
        }
    }
}

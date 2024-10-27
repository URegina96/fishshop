package com.example.fishshop.basket
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fishshop.product.Product
@Composable
fun BasketItemRow(basketItem: BasketItem, onRemove: (BasketItem) -> Unit, onIncrease: (BasketItem) -> Unit, onDecrease: (BasketItem) -> Unit) {
    Row(
        modifier = Modifier
            .background(Color(0xFF87CEEB))
            .padding(8.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = basketItem.product.imageRes),
            contentDescription = null,
            modifier = Modifier.size(80.dp)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Button(onClick = { onDecrease(basketItem) }) {
                Text(text = "-")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(text = basketItem.quantity.toString(), fontSize = 18.sp)
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { onIncrease(basketItem) }) {
                Text(text = "+")
            }
        }
        Button(onClick = { onRemove(basketItem) }) {
            Text(text = "Удалить")
        }
    }
}
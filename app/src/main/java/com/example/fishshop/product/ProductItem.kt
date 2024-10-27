package com.example.fishshop.product

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProductItem(product: Product, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .background(Color(0xFF87CEEB))
            .clickable(onClick = onClick)
            .padding(8.dp)
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(180.dp)
                .background(Color.White)
        )
        Text(
            text = product.name,
            fontSize = 18.sp,
            color = Color.Black,
            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
        )
        Text(
            text = "${product.price}₽",
            fontSize = 16.sp,
            color = Color.Green,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = onClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Добавить в корзину")
        }
    }
}
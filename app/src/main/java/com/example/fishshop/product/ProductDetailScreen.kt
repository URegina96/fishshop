package com.example.fishshop.product

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fishshop.basket.BasketViewModel

@Composable
fun ProductDetailScreen(navController: NavController, product: Product, basketViewModel: BasketViewModel, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .background(Color(0xFF87CEEB))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = product.imageRes),
            contentDescription = product.name,
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(8.dp)
        )
        Text(
            text = product.name,
            fontSize = 20.sp,
            color = Color(0xFF2F4F4F),
            modifier = Modifier.padding(top = 8.dp)
        )
        Text(
            text = "${product.price}₽",
            fontSize = 18.sp,
            color = Color(0xFF4CAF50),
            modifier = Modifier.padding(top = 4.dp)
        )
        Button(
            onClick = { basketViewModel.addToBasket(product) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
        ) {
            Text(text = "Добавить в корзину")
        }
        Button(
            onClick = { navController.popBackStack("home", false) },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(text = "Назад")
        }
    }
}

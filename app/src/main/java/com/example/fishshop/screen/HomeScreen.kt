package com.example.fishshop.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.fishshop.product.Product
import com.example.fishshop.product.ProductItem

@Composable
fun HomeScreen(navController: NavController, products: List<Product>, modifier: Modifier = Modifier) {
    val infiniteImages = remember { List(1000) { products[it % products.size] } }

    Column(
        modifier = modifier
            .background(Color(0xFFAFEEEE))
            .padding(16.dp)
            .fillMaxSize()
    ) {
        Text(
            text = "Home",
            fontSize = 24.sp,
            color = Color.Black,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.fillMaxWidth()
        ) {
            items(infiniteImages) { product ->
                Image(
                    painter = painterResource(id = product.imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(100.dp)
                        .clickable { /* Handle image click if needed */ }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { /* Даты доставки */ },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Даты доставки")
        }

        Spacer(modifier = Modifier.height(16.dp))

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            verticalArrangement = Arrangement.spacedBy(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(products) { product ->
                ProductItem(product = product, onClick = {
                    val route = "product_detail/${product.name}/${product.price}/${product.imageRes}"
                    navController.navigate(route)
                })
            }
        }
    }
}

package com.example.fishshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fishshop.basket.BasketViewModel
import com.example.fishshop.button.BottomNavigationBar
import com.example.fishshop.product.Product
import com.example.fishshop.product.ProductDetailScreen
import com.example.fishshop.product.ProductItem
import com.example.fishshop.screen.BasketScreen
import com.example.fishshop.screen.ChatScreen
import com.example.fishshop.screen.HomeScreen
import com.example.fishshop.screen.InfoScreen
import com.example.fishshop.screen.ProfileScreen
import com.example.fishshop.toolbar.CustomToolbar
@Composable
fun MainScreen() {
    val navController = rememberNavController()
    val products = listOf(
        Product("Product 1", 10.00, android.R.drawable.ic_menu_camera),
        Product("Product 2", 20.00, android.R.drawable.ic_menu_gallery),
        Product("Product 3", 30.00, android.R.drawable.ic_menu_manage)
    )
    val basketViewModel = remember { BasketViewModel() }

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
    ) { innerPadding ->
        NavHost(navController, startDestination = "home", modifier = Modifier.padding(innerPadding)) {
            composable("home") {
                HomeScreen(navController = navController, products = products, basketViewModel = basketViewModel)
            }
            composable(
                "product_detail/{name}/{price}/{imageRes}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("price") { type = NavType.FloatType },
                    navArgument("imageRes") { type = NavType.IntType }
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val price = backStackEntry.arguments?.getFloat("price") ?: 0f
                val imageRes = backStackEntry.arguments?.getInt("imageRes") ?: 0
                val product = Product(name, price.toDouble(), imageRes)
                ProductDetailScreen(navController = navController, product = product, basketViewModel = basketViewModel)
            }
            composable("basket") {
                BasketScreen(
                    navController = navController,
                    basketItems = basketViewModel.basketItems,
                    totalPrice = basketViewModel.getTotalPrice(),
                    onRemove = { basketItem -> basketViewModel.removeFromBasket(basketItem.product) },
                    onIncrease = { basketItem -> basketViewModel.increaseQuantity(basketItem) },
                    onDecrease = { basketItem -> basketViewModel.decreaseQuantity(basketItem) }
                )
            }
            composable("chat") { ChatScreen() }
            composable("info") { InfoScreen() }
            composable("profile") { ProfileScreen() }
        }
    }
}

package com.example.fishshop

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.fishshop.basket.*
import com.example.fishshop.button.BottomNavigationBar
import com.example.fishshop.product.Product
import com.example.fishshop.product.ProductDetailScreen
import com.example.fishshop.screen.*
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
            composable("info") { InfoScreen(navController = navController) }
            composable("info_detail/{name}/{details}",
                arguments = listOf(
                    navArgument("name") { type = NavType.StringType },
                    navArgument("details") { type = NavType.StringType }
                )
            ) { backStackEntry ->
                val name = backStackEntry.arguments?.getString("name") ?: ""
                val details = backStackEntry.arguments?.getString("details") ?: ""
                InfoDetailScreen(navController = navController, itemName = name, itemDetails = details)
            }
            composable("profile") { ProfileScreen() }
            composable("order_address") { OrderAddressScreen(navController) }
            composable("contact_number") { ContactNumberScreen(navController) }
            composable("order_complete") { OrderCompleteScreen(navController) }
        }
    }
}

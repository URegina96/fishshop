package com.example.fishshop.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.fishshop.info.InfoItem
import com.example.fishshop.info.InfoItemCard

@Composable
fun InfoScreen(navController: NavController) {
    val items = listOf(
        InfoItem("Первые впечатления", "Переночевав в гостинице в Гуаякиле..."),
        InfoItem("Дороги", "Дороги в Эквадоре практически идеальные...")
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(items) { item ->
            InfoItemCard(item = item, onClick = {
                navController.navigate("info_detail/${item.name}/${item.details}")
            })
        }
    }
}

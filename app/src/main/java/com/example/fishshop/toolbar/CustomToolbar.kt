// CustomToolbar.kt
package com.example.fishshop.toolbar

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CustomToolbar(
    onProfileClick: () -> Unit,
    onSearchClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF00796B))
            .padding(8.dp)
    ) {
        Text(
            text = "Ваш Логотип",
            color = Color.White,
            fontSize = 20.sp,
            modifier = Modifier.align(Alignment.Center)
        )
        IconButton(
            onClick = onProfileClick,
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(
                Icons.Default.Person,
                contentDescription = "Профиль",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
        IconButton(
            onClick = onSearchClick,
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(
                Icons.Default.Search,
                contentDescription = "Поиск",
                tint = Color.White,
                modifier = Modifier.size(48.dp)
            )
        }
    }
}

package com.example.fishshop.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

@Composable
fun MessageItem(message: Message, currentUser: String) {
    val isCurrentUser = message.sender == currentUser
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isCurrentUser) Arrangement.End else Arrangement.Start
    ) {
        Column(
            modifier = Modifier
                .background(if (isCurrentUser) Color.Blue else Color.Gray)
                .padding(8.dp)
        ) {
            Text(text = message.sender, color = Color.White)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = message.text, color = Color.White)
        }
    }
}

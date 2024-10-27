package com.example.fishshop.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import com.example.fishshop.chat.Message
import com.example.fishshop.chat.MessageItem

@Composable
fun ChatScreen() {
    var messageList by remember { mutableStateOf(mutableListOf<Message>()) }
    var currentMessage by remember { mutableStateOf(TextFieldValue("")) }
    val currentUser = "Вы"

    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.weight(1f),
            contentPadding = PaddingValues(8.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            // Добавление временных сообщений для тестирования
            items(
                listOf(
                    Message("Пользователь 1", "Привет!"),
                    Message("Пользователь 2", "Как дела?"),
                    Message("Пользователь 1", "Отлично, спасибо!")
                )
            ) { message ->
                MessageItem(message = message, currentUser = currentUser)
            }

            items(messageList) { message ->
                MessageItem(message = message, currentUser = currentUser)
            }
        }

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .background(Color.LightGray)
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            BasicTextField(
                value = currentMessage,
                onValueChange = { currentMessage = it },
                modifier = Modifier
                    .weight(1f)
                    .padding(8.dp)
                    .background(Color.White, MaterialTheme.shapes.small)
                    .padding(8.dp),
                textStyle = LocalTextStyle.current.copy(color = Color.Black)
            )
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = {
                if (currentMessage.text.isNotBlank()) {
                    messageList = messageList.toMutableList().apply { add(Message(sender = currentUser, text = currentMessage.text)) }
                    currentMessage = TextFieldValue("")
                }
            }) {
                Text(text = "Отправить")
            }
        }
    }
}

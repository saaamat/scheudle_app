package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import databases.classes.Names
import databases.requests.GetAllNames
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                SecondScreen()
            }
        }
    }

    @Composable
    fun SecondScreen() {
        var names by remember { mutableStateOf<List<Names>>(emptyList()) }

        LaunchedEffect(Unit) {

            // Выполняем корутину и обновляем состояние
            val result = withContext(Dispatchers.Default) {
                GetAllNames()
            }

            names = result
        }

        // Отображаем текст из корутины
        Text(text = names.joinToString { it.name })
    }
}

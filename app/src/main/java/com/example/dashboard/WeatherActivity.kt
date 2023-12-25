package com.example.dashboard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import databases.requests.GetWeather
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class WeatherActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                WeatherScreen()
            }
        }
    }

    @Composable
    fun WeatherScreen() {
        var weather by remember { mutableStateOf<String>("") }
        LaunchedEffect(Unit) {
            val result = withContext(Dispatchers.Default) {
                GetWeather()
            }
            weather = result
        }
        Text(text = weather)
    }
}

package com.example.vknews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.example.vknews.ui.theme.MainScreen
import com.example.vknews.ui.theme.VkNewsTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsTheme {
                MainScreen(viewModel)
            }
        }
    }
}

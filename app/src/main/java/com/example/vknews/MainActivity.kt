package com.example.vknews

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Modifier
import com.example.vknews.ui.theme.MaterialCompTest
import com.example.vknews.ui.theme.VkNewsCard
import com.example.vknews.ui.theme.VkNewsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VkNewsTheme {
                Box(modifier = Modifier
                    .background(MaterialTheme.colors.background)
                    .fillMaxSize()
                ) {
                    //VkNewsCard()
                    MaterialCompTest()
                }
            }
        }
    }
}

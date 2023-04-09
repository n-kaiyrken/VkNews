package com.example.vknews.ui.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Menu
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun MaterialCompTest() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("TopAppBar title")
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Filled.Menu, contentDescription = "")
                    }
                }
            )
        },
        bottomBar = {
            val items = listOf("Songs", "Artists", "Playlists")
            BottomNavigation() {
                for (item in items) {
                    BottomNavigationItem(
                        selected = false,
                        onClick = {},
                        icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                        label = { Text(text = item) }
                    )
                }

            }
        },
        drawerContent = {
            Text("This is drawer content")
            Spacer(Modifier.height(50.dp))
            Button(onClick = {}, content = { Text("Close drawer") })
        }
    ) {
        Text(text = "This is scaffold content", modifier = Modifier.padding(it))
    }
}


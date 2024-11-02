package com.rafaelmanzano.jetpackcomposecomponents.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyBadgeBox() {
    BadgedBox(
        badge = {
            Badge(
                contentColor = Color.White,
                containerColor = Color.Blue
            ) { Text(text = "1") }
        },
        modifier = Modifier.padding(16.dp)
    ) {
        Icon(imageVector = Icons.Default.Star, contentDescription = "")
    }
}
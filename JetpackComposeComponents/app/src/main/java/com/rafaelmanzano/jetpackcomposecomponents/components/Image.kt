package com.rafaelmanzano.jetpackcomposecomponents.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rafaelmanzano.jetpackcomposecomponents.R

@Composable
fun MyImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        alpha = 0.5f
    )
}

@Composable
fun MyImageAdvanced() {
    Image(
        painter = painterResource(id = R.drawable.ic_launcher_background),
        contentDescription = "ejemplo",
        modifier = Modifier
            .clip(CircleShape)
            .border(
                5.dp,
                Color.Red,
                CircleShape
            )
    )
}

@Composable
fun MyIcon() {
    Icon(
        imageVector = Icons.Rounded.Star,
        contentDescription = "Icono",
        tint = Color.Yellow
    )
}
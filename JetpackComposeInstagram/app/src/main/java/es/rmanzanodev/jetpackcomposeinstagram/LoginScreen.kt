package es.rmanzanodev.jetpackcomposeinstagram

import androidx.activity.compose.LocalActivity
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun LoginScreen() {
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(8.dp)) {
        Header(Modifier.align(Alignment.TopEnd))
    }
}

@Composable
fun Header(modifier: Modifier) {
    val activity = LocalActivity.current
    Icon(
        imageVector = Icons.Default.Close,
        contentDescription = "close app",
        modifier = modifier
            .padding(top = 30.dp)
            .clickable { activity?.finish() },
    )
}

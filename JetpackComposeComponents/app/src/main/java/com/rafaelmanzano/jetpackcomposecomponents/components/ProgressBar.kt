package com.rafaelmanzano.jetpackcomposecomponents.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyProgress() {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
        LinearProgressIndicator(
            modifier = Modifier.padding(top = 16.dp),
            color = Color.Red,
            trackColor = Color.Green
        )
    }
}

@Composable
fun MyProgressAdvanced() {
    var showLoading by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (showLoading) {
            CircularProgressIndicator(color = Color.Red, strokeWidth = 5.dp)
            LinearProgressIndicator(
                modifier = Modifier.padding(top = 16.dp),
                color = Color.Red,
                trackColor = Color.Green
            )
        }

        Button(
            onClick = { showLoading = !showLoading },
            modifier = Modifier.padding(10.dp)
        ) {
            Text(text = "Cargar Perfil")
        }
    }
}

@Composable
fun MyRealTestProgressBar() {
    var progress by rememberSaveable { mutableFloatStateOf(0f) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LinearProgressIndicator(progress = { progress })

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.Center,
        ) {
            Button(onClick = { progress += 0.1f }) {
                Text(text = "Incrementar")
            }

            Button(onClick = { progress -= 0.1f }) {
                Text(text = "Decrementar")
            }
        }
    }
}
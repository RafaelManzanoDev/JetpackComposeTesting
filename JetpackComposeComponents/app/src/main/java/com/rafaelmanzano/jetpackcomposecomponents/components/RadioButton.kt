package com.rafaelmanzano.jetpackcomposecomponents.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MyRadioButton() {
    var status by rememberSaveable { mutableStateOf(false) }

    Row(modifier = Modifier.fillMaxSize()) {
        RadioButton(
            selected = status,
            onClick = { status = !status },
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Red,
                unselectedColor = Color.Yellow,
                disabledSelectedColor = Color.Green,
                disabledUnselectedColor = Color.Green
            ),
            enabled = true
        )
        Text(text = "Ejemplo 1")
    }
}

@Composable
fun MyRadioButtonList(name: String, onItemSelected: (String) -> Unit) {

    Column(modifier = Modifier.fillMaxSize()) {
        Row {
            RadioButton(
                selected = name == "Rafa",
                onClick = { onItemSelected("Rafa") }
            )
            Text(text = "Rafa")
        }

        Row {
            RadioButton(
                selected = name == "Aris",
                onClick = { onItemSelected("Aris") }
            )
            Text(text = "Aris")
        }

        Row {
            RadioButton(
                selected = name == "David",
                onClick = { onItemSelected("David") }
            )
            Text(text = "David")
        }

        Row {
            RadioButton(
                selected = name == "Fulanito",
                onClick = { onItemSelected("Fulanito") }
            )
            Text(text = "Fulanito")
        }
    }
}

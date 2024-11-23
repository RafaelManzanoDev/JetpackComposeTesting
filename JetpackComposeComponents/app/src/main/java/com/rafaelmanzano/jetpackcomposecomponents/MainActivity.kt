package com.rafaelmanzano.jetpackcomposecomponents

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.rafaelmanzano.jetpackcomposecomponents.components.MyAlertDialog
import com.rafaelmanzano.jetpackcomposecomponents.components.MyConfirmationDialog
import com.rafaelmanzano.jetpackcomposecomponents.components.MyCustomDialog
import com.rafaelmanzano.jetpackcomposecomponents.components.MySimpleCustomDialog
import com.rafaelmanzano.jetpackcomposecomponents.ui.theme.JetpackComposeComponentsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeComponentsTheme {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    var show by remember { mutableStateOf(false) }
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Button(onClick = { show = true }) {
                            Text(text = "Mostrar diálogo")
                        }
                        MyConfirmationDialog(
                            show = show,
                            onDismiss = { show = false }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Column {
        //MyDialog()
    }
}





















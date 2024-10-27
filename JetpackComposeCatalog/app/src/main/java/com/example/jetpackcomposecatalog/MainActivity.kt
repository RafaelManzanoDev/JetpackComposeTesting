package com.example.jetpackcomposecatalog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecatalog.ui.theme.JetpackComposeCatalogTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposeCatalogTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyStatePropertyExample()
                }
            }
        }
    }
}

//region Componentes
@Composable
fun MyBox() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Box(
            modifier = Modifier
                .width(200.dp)
                .height(200.dp)
                .background(Color.Cyan)
                .verticalScroll(
                    rememberScrollState()
                ), contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Estoy haciendo pruebas para añadir scroll de manera muy facil en Jetpack Compose")
        }
    }
}

@Composable
fun MyColumn() {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.SpaceBetween) {
        Text(text = "Ejemplo1", modifier = Modifier.background(Color.Red))
        Text(text = "Ejemplo2", modifier = Modifier.background(Color.Black))
        Text(text = "Ejemplo3", modifier = Modifier.background(Color.Cyan))
        Text(text = "Ejemplo4", modifier = Modifier.background(Color.Green))
        Text(text = "Ejemplo5", modifier = Modifier.background(Color.Magenta))
    }
}

@Composable
fun MyRow() {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .horizontalScroll(rememberScrollState())
    ) {
        Text(
            text = "Ejemplo1", modifier = Modifier
                .background(Color.Red)
                .width(100.dp)
        )
        Text(
            text = "Ejemplo2", modifier = Modifier
                .background(Color.Black)
                .width(100.dp)
        )
        Text(
            text = "Ejemplo3", modifier = Modifier
                .background(Color.Cyan)
                .width(100.dp)
        )
        Text(
            text = "Ejemplo4", modifier = Modifier
                .background(Color.Green)
                .width(100.dp)
        )
        Text(
            text = "Ejemplo5", modifier = Modifier
                .background(Color.Magenta)
                .width(100.dp)
        )
    }
}

@Composable
fun MyComplexLayout() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {

        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola soy Rafael Manzano")
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        ) {

        }
    }
}

@Composable
fun ReplicateDesign() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan),
            contentAlignment = Alignment.Center
        ) {
            Text(text = "Ejemplo 1")
        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 2")
            }
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Ejemplo 3")
            }
        }

        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(text = "Ejemplo 4")
        }
    }
}

@Composable
fun MyComplexLayoutWithSpacer() {
    Column(Modifier.fillMaxSize()) {
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Cyan)
        ) {

        }
        MySpacer(size = 30)
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Red)
            )
            Box(
                Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .background(Color.Green),
                contentAlignment = Alignment.Center
            ) {
                Text(text = "Hola soy Rafael Manzano")
            }
        }
        MySpacer(size = 80)
        Box(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(Color.Magenta)
        ) {

        }
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height(size.dp))
}

@Composable
fun MyStateExampleRemember() {
    val counter = remember { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { counter.intValue++ }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado ${counter.intValue} veces")
    }
}

@Composable
fun MyStateExampleRememberSaveable() {
    val counter = rememberSaveable { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { counter.intValue++ }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado ${counter.intValue} veces")
    }
}

@Composable
fun MyStatePropertyExample() {
    var counter by rememberSaveable { mutableIntStateOf(0) }
    Column(modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Button(onClick = { counter++ }) {
            Text(text = "Pulsar")
        }

        Text(text = "He sido pulsado $counter veces")
    }
}
//endregion


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCatalogTheme {
        MyStatePropertyExample()
    }
}


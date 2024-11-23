package com.rafaelmanzano.jetpackcomposecomponents.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.rafaelmanzano.jetpackcomposecomponents.R

@Composable
fun MyAlertDialog(
    show: Boolean,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    if (show) {
        AlertDialog(
            onDismissRequest = { onDismiss() },
            dismissButton = {
                TextButton(onClick = { onDismiss() }) {
                    Text(text = "DismissButton")
                }
            },
            confirmButton = {
                TextButton(onClick = { onConfirm() }) {
                    Text(text = "ConfirmButton")
                }
            },
            title = { Text(text = "Titulo") },
            text = { Text(text = "Hola, soy una descripción super guay :)") }
        )
    }
}

@Composable
fun MySimpleCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
            properties = DialogProperties(dismissOnBackPress = false, dismissOnClickOutside = false)
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                Text(text = "Esto es un dialogo")
                Text(text = "Esto es un dialogo")
                Text(text = "Esto es un dialogo")
            }
        }
    }
}

@Composable
fun MyCustomDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(24.dp)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Set backup account")
                AccountItem(email = "ejemplo1@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "ejemplo2@gmail.com", drawable = R.drawable.avatar)
                AccountItem(email = "Añadir nueva cuenta", drawable = R.drawable.add)
            }
        }
    }
}

@Composable
fun MyTitleDialog(text: String, modifier: Modifier = Modifier.padding(12.dp)) {
    Text(
        text = text,
        fontWeight = FontWeight.SemiBold,
        fontSize = 20.sp,
        modifier = modifier
    )
}

@Composable
fun AccountItem(email: String, @DrawableRes drawable: Int) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Image(
            painter = painterResource(id = drawable),
            contentDescription = "avatar",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(8.dp)
                .size(40.dp)
                .clip(CircleShape)
        )
        Text(
            text = email,
            fontSize = 14.sp,
            color = Color.Gray,
            modifier = Modifier.padding(8.dp)
        )
    }
}

@Composable
fun MyConfirmationDialog(
    show: Boolean,
    onDismiss: () -> Unit,
) {
    var status by remember { mutableStateOf("") }
    if (show) {
        Dialog(
            onDismissRequest = { onDismiss() },
        ) {
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .fillMaxWidth()
            ) {
                MyTitleDialog(text = "Phone Ringtone", modifier = Modifier.padding(24.dp))
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.LightGray
                )
                MyRadioButtonConfirmDialogList(name = status) {
                    status = it
                }
                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = Color.LightGray
                )
                Row(modifier = Modifier.align(Alignment.End).padding(8.dp)) {
                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "CANCEL")
                    }

                    TextButton(onClick = { /*TODO*/ }) {
                        Text(text = "OK")
                    }
                }
            }
        }
    }
}
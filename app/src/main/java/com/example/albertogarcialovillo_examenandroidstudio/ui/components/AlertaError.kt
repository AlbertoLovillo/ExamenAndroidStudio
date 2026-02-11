package com.example.albertogarcialovillo_examenandroidstudio.ui.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.albertogarcialovillo_examenandroidstudio.viewmodel.LoginViewModel

@Composable
fun AlertaFallo(
    viewModel: LoginViewModel = viewModel<LoginViewModel>()
) {
    AlertDialog(
        title = {
            Text(text = "Login")
        },
        text = {
            Text(text = "Usuario o contraseña incorrectos")
        },
        onDismissRequest = {
            viewModel.salirMostrarError()
        },
        confirmButton = { },
        dismissButton = {
            TextButton(
                onClick = {
                    viewModel.salirMostrarError()
                }
            ) {
                Text("Aceptar")
            }
        }
    )
}

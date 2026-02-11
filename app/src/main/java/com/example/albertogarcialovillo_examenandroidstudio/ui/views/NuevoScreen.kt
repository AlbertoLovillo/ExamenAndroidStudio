package com.example.albertogarcialovillo_examenandroidstudio.ui.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.albertogarcialovillo_examenandroidstudio.viewmodel.HomeViewModel

@Composable
fun NuevoScreen(
    viewModel: HomeViewModel = viewModel<HomeViewModel>(),
    goBack: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Nuevo jugador",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = uiState.nombre,
            onValueChange = { viewModel.actualizarNombre(it) },
            label = { Text("Nombre") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = "${uiState.numero}",
            onValueChange = { viewModel.actualizarNumero(it.toInt()) },
            label = { Text("Numero") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = uiState.nacionalidad,
            onValueChange = { viewModel.actualizarNacionalidad(it) },
            label = { Text("Posicion") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = uiState.posicion,
            onValueChange = { viewModel.actualizarPosicion(it) },
            label = { Text("Nacionalidad") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            value = uiState.imagenUrl,
            onValueChange = { viewModel.actualizarImagenUrl(it) },
            label = { Text("URL Imagen") }
        )

        Spacer(modifier = Modifier.height(20.dp))

        Row() {
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(1f),
                onClick = {
                    viewModel.anyadirFirestore()
                    goBack()
                },
                colors = ButtonColors(
                    containerColor = Color(0xFF27D21F),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFF27D21F),
                    disabledContentColor = Color.Black
                ),
            ) {
                Text(
                    text = "Agregar"
                )
            }

            Spacer(modifier = Modifier.width(20.dp))

            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp)
                    .weight(1f),
                onClick = goBack,
                colors = ButtonColors(
                    containerColor = Color(0xFF27D21F),
                    contentColor = Color.Black,
                    disabledContainerColor = Color(0xFF27D21F),
                    disabledContentColor = Color.Black
                ),
            ) {
                Text(
                    text = "Cancelar"
                )
            }
        }
    }
}
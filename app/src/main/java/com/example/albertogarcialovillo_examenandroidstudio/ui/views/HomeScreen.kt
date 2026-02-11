package com.example.albertogarcialovillo_examenandroidstudio.ui.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.albertogarcialovillo_examenandroidstudio.ui.components.CardJugador
import com.example.albertogarcialovillo_examenandroidstudio.viewmodel.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel<HomeViewModel>(),
    goNuevo: () -> Unit,
) {
    val uiState by viewModel.uiState.collectAsState()
    val jugador by viewModel.jugador.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Plantilla temporada 25/26",
            fontSize = 40.sp
        )

        Spacer(Modifier.height(20.dp))

        LazyColumn(Modifier.fillMaxWidth().height(400.dp)) {
            items(jugador) { item ->
                CardJugador(
                    nombre = item.nombre,
                    numero = item.numero,
                    nacionalidad = item.nacionalidad,
                    posicion = item.posicion,
                    imagenUrl = item.imagenUrl
                )
            }
        }

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = goNuevo,
            colors = ButtonColors(
                containerColor = Color(0xFF27D21F),
                contentColor = Color.Black,
                disabledContainerColor = Color(0xFF27D21F),
                disabledContentColor = Color.Black
            ),
        ) {
            Text(
                text = "Iniciar sesion"
            )
        }
    }
}
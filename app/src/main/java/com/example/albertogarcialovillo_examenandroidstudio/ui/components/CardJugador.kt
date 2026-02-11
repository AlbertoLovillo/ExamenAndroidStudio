package com.example.albertogarcialovillo_examenandroidstudio.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.example.albertogarcialovillo_examenandroidstudio.R
import com.example.albertogarcialovillo_examenandroidstudio.viewmodel.HomeViewModel

@Composable
fun CardJugador(
    viewModel: HomeViewModel = viewModel<HomeViewModel>(),
    id: String,
    nombre: String,
    numero: Int,
    nacionalidad: String,
    posicion: String,
    imagenUrl: String
) {
    Card(
        colors = CardColors(
            containerColor = Color(0xFFF2FCEE),
            contentColor = Color.Black,
            disabledContainerColor = Color(0xFFF2FCEE),
            disabledContentColor = Color.Black
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(300.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(300.dp)
                .padding(10.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Spacer(modifier = Modifier.weight(1f))

                AsyncImage(
                    model = imagenUrl,
                    contentDescription = null,
                    modifier = Modifier.height(200.dp)
                )

                Spacer(modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(10.dp))

            Row(Modifier.fillMaxWidth()) {
                Button(
                    onClick = {},
                    colors = ButtonColors(
                        containerColor = Color(0xFF27D21F),
                        contentColor = Color.Black,
                        disabledContainerColor = Color(0xFF27D21F),
                        disabledContentColor = Color.Black
                    ),
                    shape = CircleShape,
                    modifier = Modifier.size(50.dp)
                ) {
                    Text(
                        text = "$numero"
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Column() {
                    Text(
                        text = nombre,
                        fontSize = 20.sp
                    )

                    Text(
                        text = nacionalidad,
                        fontSize = 15.sp
                    )

                    Text(
                        text = posicion,
                        fontSize = 15.sp
                    )
                }

                Spacer(modifier = Modifier.width(10.dp))

                Icon(
                    painter = painterResource(R.drawable.outline_auto_delete_24),
                    contentDescription = null,
                    modifier = Modifier
                        .clickable {
                            viewModel.eliminarFirestore(id)
                        }
                        .size(20.dp)
                )
            }
        }
    }

}
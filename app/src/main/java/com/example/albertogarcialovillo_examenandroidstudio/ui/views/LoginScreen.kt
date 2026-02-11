package com.example.albertogarcialovillo_examenandroidstudio.ui.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.albertogarcialovillo_examenandroidstudio.R
import com.example.albertogarcialovillo_examenandroidstudio.viewmodel.LoginViewModel
import com.google.firebase.auth.FirebaseAuth


@Composable
fun LoginScreen(
    auth: FirebaseAuth,
    viewModel: LoginViewModel = viewModel<LoginViewModel>(),
    goHome: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    var hide by remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Image(
            modifier = Modifier.size(300.dp),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = "INICIA SESION",
            fontSize = 40.sp
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            value = uiState.email,
            onValueChange = { viewModel.actualizarEmail(it) },
            label = "Email"
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            value = uiState.contrasenya,
            onValueChange = { viewModel.actualizarContasenya(it) },
            label = "Email",
            trailingIcon = Text(
                modifier = Modifier.clickable { hide = !hide },
                text = "Mostrar"
            ),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = if (hide) PasswordVisualTransformation() else VisualTransformation.None
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            onClick = { viewModel.iniciarSesion(auth, goHome) },
            colors = ButtonColors(
                containerColor = Color(0xFF27D21F),
                contentColor = Color.Black,
                disabledContainerColor = Color(0xFF27D21F),
                disabledContentColor = Color.Black
            ),
        ) {

        }
    }
}
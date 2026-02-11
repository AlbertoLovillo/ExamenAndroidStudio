package com.example.albertogarcialovillo_examenandroidstudio.models

data class LoginUiState(
    val email: String = "",
    val contrasenya: String = "",
    val mostrarError: Boolean = false
)
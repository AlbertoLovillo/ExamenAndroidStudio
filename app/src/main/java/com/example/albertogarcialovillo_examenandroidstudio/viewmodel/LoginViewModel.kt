package com.example.albertogarcialovillo_examenandroidstudio.viewmodel

import androidx.lifecycle.ViewModel
import com.example.albertogarcialovillo_examenandroidstudio.models.LoginUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class LoginViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun actualizarEmail(valor: String) {
        _uiState.update { it.copy(email = valor) }
    }

    fun actualizarContasenya(valor: String) {
        _uiState.update { it.copy(contrasenya = valor) }
    }

    fun entrarMostrarError() {
        _uiState.update { it.copy(mostrarError = true) }
    }

    fun salirMostrarError() {
        _uiState.update { it.copy(mostrarError = false) }
    }

}
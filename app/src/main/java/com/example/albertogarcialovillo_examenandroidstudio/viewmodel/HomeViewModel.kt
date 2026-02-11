package com.example.albertogarcialovillo_examenandroidstudio.viewmodel

import androidx.lifecycle.ViewModel
import com.example.albertogarcialovillo_examenandroidstudio.models.HomeUiState
import com.example.albertogarcialovillo_examenandroidstudio.models.Jugador
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlin.String

class HomeViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState.asStateFlow()

    private val _jugador = MutableStateFlow<List<Jugador>>(emptyList())
    val jugador: StateFlow<List<Jugador>> = _jugador

    private val db = Firebase.firestore
    private val jugadorCollection = db.collection("jugadores")

    init {
        leerFirestore()
    }

    fun actualizarNombre(valor: String) {
        _uiState.update { it.copy(nombre = valor) }
    }
    fun actualizarNumero(valor: Int) {
        _uiState.update { it.copy(numero = valor) }
    }
    fun actualizarNacionalidad(valor: String) {
        _uiState.update { it.copy(nacionalidad = valor) }
    }
    fun actualizarPosicion(valor: String) {
        _uiState.update { it.copy(posicion = valor) }
    }
    fun actualizarImagenUrl(valor: String) {
        _uiState.update { it.copy(imagenUrl = valor) }
    }

    fun leerFirestore() {
        jugadorCollection.addSnapshotListener { snapshot, error ->
            if (error != null) {
                return@addSnapshotListener
            }
            if (snapshot != null) {
                val jugdorList = snapshot.documents.mapNotNull { doc ->
                    val jugador = doc.toObject(Jugador::class.java)
                    jugador?.id = doc.id
                    jugador
                }
            }
        }
    }

    fun anyadirFirestore() {
        val jugador = Jugador(
            nombre = _uiState.value.nombre,
            numero = _uiState.value.numero,
            nacionalidad = _uiState.value.nacionalidad,
            posicion = _uiState.value.posicion,
            imagenUrl = _uiState.value.imagenUrl,
        )
        jugadorCollection.add(jugador)
    }

    fun eliminarFirestore(id: String) {
        jugadorCollection.document(id).delete()
    }
}
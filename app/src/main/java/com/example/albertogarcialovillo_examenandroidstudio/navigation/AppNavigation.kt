package com.example.albertogarcialovillo_examenandroidstudio.navigation

import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(auth: FirebaseAuth) {
    val backStack = rememberNavBackStack(Routes.Login)

    NavDisplay(
        backStack = backStack,
        onBack = { backStack.removeLastOrNull() },
        entryProvider = entryProvider {
            entry<Routes.Login> {

            }

            entry<Routes.Home> {

            }

            entry<Routes.Detalles> {

            }

            entry<Routes.Nuevo> {

            }
        }
    )
}
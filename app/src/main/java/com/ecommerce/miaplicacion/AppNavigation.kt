package com.ecommerce.miaplicacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

// Esta función define la navegación principal de la aplicación usando Jetpack Compose
@Composable
fun AppNavigation() {

    // Crea y recuerda un controlador de navegación que gestionará las pantallas (rutas)
    val navCcontroller = rememberNavController()

    // Define el host de navegación, que contiene todas las rutas de la app
    // El parámetro 'startDestination' indica cuál es la pantalla inicial
    NavHost(
        navController = navCcontroller,
        startDestination = AppsScreen.inicio.route
    ) {

        // Primera ruta: pantalla de inicio
        composable(route = AppsScreen.inicio.route) {
            // Llama a la función composable 'inicio', pasando el controlador de navegación
            inicio(navCcontroller)
        }

        // Segunda ruta: pantalla de detalle
        // Esta ruta recibe parámetros (imagen, título y descripción)
        composable(
            route = "detalle/{imagen}/{titulo}/{descripcion}",
            arguments = listOf(
                // Se definen los argumentos esperados en la ruta con sus tipos
                navArgument("imagen") { type = NavType.IntType },
                navArgument("titulo") { type = NavType.StringType },
                navArgument("descripcion") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            // Se obtienen los argumentos pasados desde la pantalla anterior
            val imagen = backStackEntry.arguments?.getInt("imagen") ?: 0
            val titulo = backStackEntry.arguments?.getString("titulo").orEmpty()
            val descripcion = backStackEntry.arguments?.getString("descripcion").orEmpty()

            // Llama al composable 'detalle' y le pasa los datos obtenidos
            detalle(navCcontroller, imagen, titulo, descripcion)
        }
    }
}

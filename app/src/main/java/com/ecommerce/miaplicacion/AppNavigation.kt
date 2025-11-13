package com.ecommerce.miaplicacion

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

@Composable
fun AppNavigation(){
    val navCcontroller = rememberNavController()
    NavHost(navController = navCcontroller, startDestination = AppsScreen.inicio.route) {

        composable(route = AppsScreen.inicio.route) {
            inicio(navCcontroller)
        }

        composable(
            route = "detalle/{imagen}/{titulo}/{descripcion}",
            arguments = listOf(
                navArgument("imagen") { type = NavType.IntType },
                navArgument("titulo") { type = NavType.StringType },
                navArgument("descripcion") { type = NavType.StringType }
            )
        ) { backStackEntry ->
            val imagen = backStackEntry.arguments?.getInt("imagen") ?: 0
            val titulo = backStackEntry.arguments?.getString("titulo").orEmpty()
            val descripcion = backStackEntry.arguments?.getString("descripcion").orEmpty()

            detalle(navCcontroller,imagen,titulo,descripcion)

        }
    }
}
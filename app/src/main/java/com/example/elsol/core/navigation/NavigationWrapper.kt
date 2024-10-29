package com.example.elsol.core.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.elsol.Menus
import com.example.elsol.PlanetariumDate

@Composable
fun NavigationWrapper() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Menus) {
        composable<Menus> {
            Menus { navController.navigate(PlanetariumDate) }
        }

        composable<PlanetariumDate> {
            PlanetariumDate()
        }
    }
}
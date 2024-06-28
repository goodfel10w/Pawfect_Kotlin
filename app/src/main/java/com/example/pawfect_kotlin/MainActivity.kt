package com.example.pawfect_kotlin

import SwipeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pawfect_kotlin.ui.theme.Pawfect_KotlinTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Pawfect_KotlinTheme {
                NavHost(
                    navController = navController,
                    startDestination = PawfectDestinations.Start.name,
                ) {
                    composable(route = PawfectDestinations.Start.name) {
                        SwipeScreen(navController = navController)
                    }

                    composable(route = PawfectDestinations.Filter.name) {
                        FilterScreen(navController = navController)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pawfect_KotlinTheme {
        SwipeScreen(viewModel = SwipeViewModel())
    }
}
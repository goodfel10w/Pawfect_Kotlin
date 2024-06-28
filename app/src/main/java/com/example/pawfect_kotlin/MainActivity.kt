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


// Dies ist die Hauptaktivität der App, die startet, wenn die App geöffnet wird
class MainActivity : ComponentActivity() {
    // Diese Methode wird aufgerufen, wenn die Aktivität erstellt wird
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Aktiviert den Edge-to-Edge-Modus, um die App über den gesamten Bildschirmbereich zu erstrecken
        enableEdgeToEdge()

        // Setzt den Inhalt der Aktivität, hier wird die Benutzeroberfläche definiert
        setContent {
            // Erzeugt einen Navigation Controller, der die Navigation zwischen verschiedenen Bildschirmen in der App verwaltet
            val navController = rememberNavController()

            // Setzt das Thema der App
            Pawfect_KotlinTheme {
                // Definiert den NavHost, der die Navigation in der App verwaltet
                NavHost(
                    navController = navController, // Übergibt den Navigation Controller
                    startDestination = PawfectDestinations.Start.name, // Startbildschirm der App
                ) {
                    // Definiert einen Bildschirm für die Navigation
                    composable(route = PawfectDestinations.Start.name) {
                        // Lädt den SwipeScreen, wenn dieser Bildschirm ausgewählt ist
                        SwipeScreen(navController = navController)
                    }

                    // Definiert einen weiteren Bildschirm für die Navigation
                    composable(route = PawfectDestinations.Filter.name) {
                        // Lädt den FilterScreen, wenn dieser Bildschirm ausgewählt ist
                        FilterScreen(navController = navController)
                    }
                }
            }
        }
    }
}

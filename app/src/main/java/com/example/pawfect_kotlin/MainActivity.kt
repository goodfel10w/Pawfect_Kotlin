package com.example.pawfect_kotlin

import SwipeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.example.pawfect_kotlin.ui.theme.Pawfect_KotlinTheme
import com.example.pawfect_kotlin.SwipeViewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Pawfect_KotlinTheme {
                SwipeScreen()
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
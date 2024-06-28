package com.example.pawfect_kotlin

import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun FilterScreen(viewModel: FilterViewModel = viewModel(),
                 navController: NavController) {
    val uiState by viewModel.uiState.collectAsState()

    Column(horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .padding(start = 32.dp, end = 32.dp)) {

        // Entfernung-Filter
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Icon(
                painter = painterResource(id = R.drawable.home_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Größe",
                )
            Text(
                text = "Entfernung",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Slider(
                value = uiState.distance,
                onValueChange = { viewModel.updateDistance(it) }
            )
            Text(text = uiState.distance.toString())
        }

        // Absicht-Filter
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Icon(
                painter = painterResource(id = R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Absicht",
            )
            Text(
                text = "Absicht",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Zuchtpartner")
                    Checkbox(
                        checked = uiState.zuchtpartner,
                        onCheckedChange = { viewModel.updateZuchtpartner(it) }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Spielpartner")
                    Checkbox(
                        checked = uiState.spielpartner,
                        onCheckedChange = { viewModel.updateSpielpartner(it) }
                    )
                }
            }
        }

        // Tierart-Filter
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Icon(
                painter = painterResource(id = R.drawable.pets_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Tierart",
            )
            Text(
                text = "Tierart",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp))
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Hund")
                    Checkbox(
                        checked = uiState.hund,
                        onCheckedChange = { viewModel.updateHund(it) }
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Katze")
                    Checkbox(
                        checked = uiState.katze,
                        onCheckedChange = { viewModel.updateKatze(it) }
                    )
                }
            }
        }

        // Alter-Filter
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Icon(
                painter = painterResource(id = R.drawable.cake_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Alter",
            )
            Text(
                text = "Alter",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Slider(
                value = uiState.minAge,
                onValueChange = { viewModel.updateMinAge(it) }
            )
            Text(text = uiState.minAge.toString())
        }

        // Größe-Filter
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Icon(
                painter = painterResource(id = R.drawable.square_foot_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Größe",
            )
            Text(
                text = "Größe",
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp))
        }

        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Slider(
                value = uiState.maxSize,
                onValueChange = { viewModel.updateMaxSize(it) }
            )
            Text(text = uiState.maxSize.toString())
        }

        // Buttons für Bestätigen und Zurücksetzen
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            Button(
                onClick = { viewModel.applyFilters() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
            ) {
                Text(text = "Bestätigen")
            }
            Button(
                onClick = { viewModel.resetFilters() },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
            ) {
                Text(text = "Zurücksetzen")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyFilterPreview(){
    FilterScreen(navController = rememberNavController())
}
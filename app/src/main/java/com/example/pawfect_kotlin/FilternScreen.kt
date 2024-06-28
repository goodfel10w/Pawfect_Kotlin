package com.example.pawfect_kotlin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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
    var sliderEntfernungPosition by remember { mutableFloatStateOf(0f) }
    var sliderAlterPosition by remember { mutableFloatStateOf(0f) }
    var sliderGroessePosition by remember { mutableFloatStateOf(0f) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .padding(start = 32.dp, end = 32.dp)
    )
    {
        Spacer(modifier = Modifier.height(32.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Größe",
            )
            Text(
                text = "Entfernung",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {

            Slider(
                value = uiState.distance,
                onValueChange = { viewModel.updateDistance(it) },
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Black,
                    inactiveTrackColor = Color.Gray
                ),
                steps = 99,
                valueRange = 0f..100f
            )
        }
        Text(text = uiState.distance.toString() + " km")

        Spacer(modifier = Modifier.height(16.dp))

        // Absicht-Filter
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Absicht",
            )
            Text(
                text = "Absicht",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Zuchtpartner")
                Checkbox(
                    checked = uiState.zuchtpartner,
                    onCheckedChange = { viewModel.updateZuchtpartner(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Black,
                        uncheckedColor = Color.Gray
                    )
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Spielpartner")
                Checkbox(
                    checked = uiState.spielpartner,
                    onCheckedChange = { viewModel.updateSpielpartner(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Black,
                        uncheckedColor = Color.Gray
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Tierart-Filter
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.pets_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Tierart",
            )
            Text(
                text = "Tierart",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Hund")
                Checkbox(
                    checked = uiState.hund,
                    onCheckedChange = { viewModel.updateHund(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Black,
                        uncheckedColor = Color.Gray
                    )
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text("Katze")
                Checkbox(
                    checked = uiState.katze,
                    onCheckedChange = { viewModel.updateKatze(it) },
                    colors = CheckboxDefaults.colors(
                        checkedColor = Color.Black,
                        uncheckedColor = Color.Gray
                    )
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Alter-Filter
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.cake_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Alter",
            )
            Text(
                text = "Alter",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Slider(
                value = uiState.minAge,
                onValueChange = { viewModel.updateMinAge(it) },
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Black,
                    inactiveTrackColor = Color.Gray
                ),
                steps = 19,
                valueRange = 0f..20f
            )
        }
        Text(text = uiState.minAge.toString() + " Jahre")

        Spacer(modifier = Modifier.height(16.dp))

        // Größe-Filter
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.square_foot_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Größe",
            )
            Text(
                text = "Größe",
                fontSize = 15.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
                    .padding(bottom = 4.dp)
                    .padding(end = 4.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Slider(
                value = uiState.maxSize,
                onValueChange = { viewModel.updateMaxSize(it) },
                colors = SliderDefaults.colors(
                    thumbColor = Color.Black,
                    activeTrackColor = Color.Black,
                    inactiveTrackColor = Color.Gray
                ),
                steps = 99,
                valueRange = 0f..100f
            )
        }
        Text(text = uiState.maxSize.toString() + " cm")

        Spacer(modifier = Modifier.height(16.dp))

        // Buttons für Bestätigen und Zurücksetzen
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 4.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        )
        {
            Button(
                onClick = {
                    //viewModel.applyFilters()
                    navController.navigate(PawfectDestinations.Start.name)
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
            ) {
                Text(text = "Bestätigen")
            }
            Button(
                onClick = { viewModel.resetFilters() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Black,
                    contentColor = Color.White
                )
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
package com.example.pawfect_kotlin

import androidx.compose.foundation.layout.*
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

//Screen für die Filter Einstellungen
@Composable
fun FilterScreen(viewModel: FilterViewModel = viewModel(),
                 navController: NavController) {
    val uiState by viewModel.uiState.collectAsState()

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .padding(start = 32.dp, end = 32.dp)
    )
    {
        //Abstand zur Decke
        Spacer(modifier = Modifier.height(32.dp))

        //Icon und Text für die Entfernung-Elemente
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.home_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = "Entfernung",
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

        //Slider für Entfernung und speichern der Slider Postition
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
                //Wertespektrum und Abstufungengen, damit man nur ganze Zahlen auswählen kann
                steps = 99,
                valueRange = 0f..100f
            )
        }
        //Aktuelle Positions des Sliders ausgeben
        Text(text = uiState.distance.toString() + " km")

        //Abstand zu dem nächsten Attribut
        Spacer(modifier = Modifier.height(16.dp))

        // Absicht-Filter mit Text und der Icon
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

        //Die Checkboxen um die verschiedenen Absichten auszuwählen
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
        //Abstand zu dem nächsten Attribut
        Spacer(modifier = Modifier.height(16.dp))

        // Tierart-Filter mit Text und Icon
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

        //Checkboxen mit denen man die Tierarten auswählen kann
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
        //Abstand zu dem nächsten Attribut
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
        //Slider um Alter auswählen zu können
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
                //Wertespektrum und Abstufungengen, damit man nur ganze Zahlen auswählen kann
                steps = 19,
                valueRange = 0f..20f
            )
        }
        //Positions des Sliders ausgeben
        Text(text = uiState.minAge.toString() + " Jahre")

        //Abstand zu dem nächsten Attribut
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

        //Slider zum auswählen der Größe
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
                //Wertespektrum und Abstufungengen, damit man nur ganze Zahlen auswählen kann
                steps = 99,
                valueRange = 0f..100f
            )
        }
        //Positions des Sliders ausgeben
        Text(text = uiState.maxSize.toString() + " cm")

        //Abstand zu dem nächsten Attribut
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
                    viewModel.applyFilters()
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
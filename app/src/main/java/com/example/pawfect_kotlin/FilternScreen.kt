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

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            var sliderEntfernungPosition by remember { mutableFloatStateOf(0f) }

            Slider(
                value = sliderEntfernungPosition,
                onValueChange = { sliderEntfernungPosition = it },
                colors=SliderDefaults.colors(
                    thumbColor=Color.Black,
                    activeTrackColor=Color.Black,
                    inactiveTrackColor=Color.Gray
                )
            )
            Text(text = sliderEntfernungPosition.toString())
        }

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

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            var checkedZuchtpartner by remember { mutableStateOf(true) }
            var checkedSpielpartner by remember { mutableStateOf(true) }

            Text(
                "Zuchtpartner"
            )
            Checkbox(
                checked = checkedZuchtpartner,
                onCheckedChange = { checkedZuchtpartner = it },
                colors=CheckboxDefaults.colors(
                    checkedColor=Color.Black,
                    uncheckedColor=Color.Gray
                )

            )

            Text(
                "Spielpartner"
            )
            Checkbox(
                checked = checkedSpielpartner,
                onCheckedChange = { checkedSpielpartner = it },
                colors=CheckboxDefaults.colors(
                    checkedColor=Color.Black,
                    uncheckedColor=Color.Gray
                )
            )
        }

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
            var checkedHund by remember { mutableStateOf(true) }
            var checkedKatze by remember { mutableStateOf(true) }

            Text(
                "Hund"
            )
            Checkbox(
                checked = checkedHund,
                onCheckedChange = { checkedHund = it },
                colors=CheckboxDefaults.colors(
                    checkedColor=Color.Black,
                    uncheckedColor=Color.Gray
                )
            )

            Text(
                "Katze"
            )
            Checkbox(
                checked = checkedKatze,
                onCheckedChange = { checkedKatze = it },
                colors=CheckboxDefaults.colors(
                    checkedColor=Color.Black,
                    uncheckedColor=Color.Gray
                )
            )
        }

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

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp)
            .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            var sliderAlterPosition by remember { mutableFloatStateOf(0f) }
            Slider(
                value = sliderAlterPosition,
                onValueChange = { sliderAlterPosition = it },
                colors=SliderDefaults.colors(
                    thumbColor=Color.Black,
                    activeTrackColor=Color.Black,
                    inactiveTrackColor=Color.Gray
                )
            )
            Text(text = sliderAlterPosition.toString())
        }

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically,  ) {
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

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
            var sliderGroessePosition by remember { mutableFloatStateOf(0f) }

            Slider(
                value = sliderGroessePosition,
                onValueChange = { sliderGroessePosition = it },
                colors=SliderDefaults.colors(
                    thumbColor=Color.Black,
                    activeTrackColor=Color.Black,
                    inactiveTrackColor=Color.Gray
                )
            )
            Text(text = sliderGroessePosition.toString())
        }

        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 4.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {

            Button(
                onClick = { /* Apply filters and navigate or show results */ },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Black, contentColor = Color.White)
            ) {
                Text(text = "Bestätigen")
            }
            Button(
                onClick = { /* Apply filters and navigate or show results */ },
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
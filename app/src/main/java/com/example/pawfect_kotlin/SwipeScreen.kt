import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pawfect_kotlin.PawfectDestinations
import com.example.pawfect_kotlin.R
import com.example.pawfect_kotlin.SwipeViewModel
import androidx.compose.material3.IconButton as IconButton1

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeScreen(
    viewModel: SwipeViewModel = viewModel(),
    navController: NavHostController = rememberNavController()) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                actions = {
                    IconButton1(onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter_alt_24px),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize())
                    }
                },
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = PawfectDestinations.Start.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = PawfectDestinations.Start.name ) {
            }
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.pawfect_logo),
                contentDescription = "Logo",
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .height(100.dp)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            ProfileCard()
            ProfileInformation()
            BottomAppBarExample()
        }
    }
}

@Composable
private fun ProfileCard(
    modifier: Modifier = Modifier,
    viewModel: SwipeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    Card(
        modifier = modifier
            .background(Color.White)
            .padding(16.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .border(width = 1.dp, color = Color.LightGray)
            ,
        colors = CardDefaults.cardColors(containerColor = Color.White)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(300.dp)
                    .align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(R.drawable.dog_example),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))

                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = uiState.animalProfiles[0].name,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row {
                    Text(
                        text = uiState.animalProfiles[0].species + ",",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = uiState.animalProfiles[0].breed,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                    )
                }
            }
        }
    }
}

@Composable
private fun ProfileInformation(viewModel: SwipeViewModel = viewModel()) {
        val uiState by viewModel.uiState.collectAsState()
        Column(horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(16.dp)
                    .padding(start = 32.dp, end = 32.dp)) {
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.square_foot_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = stringResource(R.string.alter_und_groese),

                )
                Text(
                    text = stringResource(R.string.alter) + uiState.animalProfiles[uiState.indexOfList].age.toString()
                    + ", " + uiState.animalProfiles[uiState.indexOfList].size + " cm",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .padding(end = 4.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp))
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.user_attributes_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = "Eigenschaften"
                )
                Text(
                    text = uiState.animalProfiles[uiState.indexOfList].characteristics,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                )
            }
            HorizontalDivider( thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp))
            Row(horizontalArrangement = Arrangement.Start) {
                Icon(
                    painter = painterResource(id = R.drawable.person_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = stringResource(R.string.name_des_tierhalters),

                )
                Text(text = uiState.userProfiles[uiState.indexOfList].firstName + " " + uiState.userProfiles[uiState.indexOfList].lastName,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier)
        }
    }
}

@Composable
fun BottomAppBarExample() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                contentPadding = PaddingValues(horizontal = 16.dp),
                modifier = Modifier.background(Color.White)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column {
                        IconButton1(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.sms_24dp_fill0_wght400_grad0_opsz24),
                                contentDescription = null // decorative element
                            )
                        }
                        Text(stringResource(R.string.chats), modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    Column{
                        IconButton1(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24),
                                contentDescription = null // decorative element
                            )
                        }
                        Text(stringResource(R.string.swipen), modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                    Column {
                        IconButton1(onClick = { /* do something */ }) {
                            Icon(
                                painter = painterResource(id = R.drawable.person_24dp_fill0_wght400_grad0_opsz24),
                                contentDescription = null // decorative element
                            )
                        }
                        Text(stringResource(R.string.profil), modifier = Modifier.align(Alignment.CenterHorizontally))
                    }
                }
            }
        },
    ) { innerPadding ->
        // Content
    }
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    SwipeScreen(viewModel = SwipeViewModel())
}


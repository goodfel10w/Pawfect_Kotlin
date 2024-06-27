import androidx.compose.animation.core.Animatable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.IntOffset
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
import kotlin.math.absoluteValue
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
            ProfileCardWithSwipe(onSwipe = { /*TODO*/ }) {
                
            }
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
                    text = uiState.animalProfiles[0].name + ", " + uiState.animalProfiles[uiState.indexOfList].age,
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
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
                Icon(
                    painter = painterResource(id = R.drawable.square_foot_24dp_fill0_wght400_grad0_opsz24),
                    contentDescription = "Größe",

                )
                Text(
                    text = uiState.animalProfiles[uiState.indexOfList].size.toString() + " cm",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .padding(end = 4.dp))
            }
            HorizontalDivider(thickness = 1.dp, color = Color.Black, modifier = Modifier.padding(top = 2.dp, bottom = 2.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
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
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically ) {
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

@Composable
fun ProfileCardWithSwipe(
    modifier: Modifier = Modifier,
    draggable: Boolean = true,
    onSwipe: () -> Unit,
    content: @Composable () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    val sizePx = with(LocalDensity.current) { 300.dp.toPx() }

    val offsetXState = remember { Animatable(0f) }
    val offsetYState = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        offsetXState.animateTo(0f)
        offsetYState.animateTo(0f)
    }

    val gestureDetector = Modifier.pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {
                // Reset position when drag ends
                offsetX = 0f
                offsetY = 0f
            }
        ) { change, dragAmount ->
            change.consume()
            offsetX += dragAmount.x
            offsetY += dragAmount.y
        }
    }

    ProfileCard(modifier = Modifier
        .offset { IntOffset(offsetX.toInt(), offsetY.toInt()) }
        .draggable(
            orientation = Orientation.Horizontal,
            state = rememberDraggableState { delta ->
                offsetX += delta
            }
        )
        .draggable(
            orientation = Orientation.Vertical,
            state = rememberDraggableState { delta ->
                offsetY += delta
            }
        )
        .graphicsLayer {
            val rotationAngle = offsetX / sizePx * 30
            rotationZ = rotationAngle
            var alpha = (offsetX / sizePx).coerceIn(-1f, 1f).absoluteValue
            alpha = 1 - alpha
            this.alpha = alpha
        }
        .then(gestureDetector)
    )
}

@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    SwipeScreen(viewModel = SwipeViewModel())
}

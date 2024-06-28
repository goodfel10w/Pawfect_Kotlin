import android.util.Log
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import androidx.compose.ui.draw.alpha
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
import androidx.navigation.compose.rememberNavController
import com.example.pawfect_kotlin.PawfectDestinations
import com.example.pawfect_kotlin.R
import com.example.pawfect_kotlin.SwipeViewModel
import com.example.pawfect_kotlin.data.SwipeUiState
import kotlinx.coroutines.delay
import kotlin.math.absoluteValue
import androidx.compose.material3.IconButton as IconButton1

const val TAG = "RoutingActivity"

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SwipeScreen(
    viewModel: SwipeViewModel = viewModel(),
    navController: NavHostController
) {

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("") },
                actions = {
                    IconButton1(onClick = {
                        Log.v(TAG, "Route to Filter triggered")
                        navController.navigate(PawfectDestinations.Filter.name) {
                            launchSingleTop = true
                        }
                    }) {
                        Icon(
                            painter = painterResource(id = R.drawable.filter_alt_24px),
                            contentDescription = "",
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                },
            )
        },
        bottomBar = {
            BottomAppBarExample()
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

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
            ProfileCardWithSwipe(
                uiState = uiState,
                onSwipeRight = {
                    viewModel.addLike()
                },
                onSwipeLeft = {
                    viewModel.addDislike()
                }
            )
            ProfileInformation()
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
            .padding(16.dp)
            .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
            .border(width = 1.dp, color = Color.LightGray),
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
                UseCorrectProfilePictureUnfiltered(uiState = uiState)
                if( uiState.matchExists) {
                    AlertDialogMatch(
                        onDismissRequest = { viewModel.consumeMatch() },
                        onConfirmation = { viewModel.consumeMatch() },
                        dialogTitle = "Es ist ein MATCH!",
                        dialogText = "Herzlichen Glückwünsch"
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Text(
                    text = uiState.animalProfiles[uiState.indexOfList].name + ", " + uiState.animalProfiles[uiState.indexOfList].age,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Medium,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Row {
                    Text(
                        text = uiState.animalProfiles[uiState.indexOfList].species + ",",
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Medium,
                        modifier = Modifier
                            .padding(bottom = 4.dp)
                            .padding(end = 4.dp)
                    )
                    Text(
                        text = uiState.animalProfiles[uiState.indexOfList].breed,
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
fun ProfileInformation(viewModel: SwipeViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    Column(
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(16.dp)
            .padding(start = 32.dp, end = 32.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
                    .padding(end = 4.dp)
            )
        }
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Black,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
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
        HorizontalDivider(
            thickness = 1.dp,
            color = Color.Black,
            modifier = Modifier.padding(top = 2.dp, bottom = 2.dp)
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.person_24dp_fill0_wght400_grad0_opsz24),
                contentDescription = stringResource(R.string.name_des_tierhalters),

                )
            Text(
                text = uiState.userProfiles[uiState.indexOfList].firstName + " " + uiState.userProfiles[uiState.indexOfList].lastName,
                fontSize = 12.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier
            )
        }
    }
}

@Composable
fun BottomAppBarExample() {
    BottomAppBar(
        contentPadding = PaddingValues(horizontal = 0.dp),
        modifier = Modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Column {
                IconButton1(onClick = { /*  */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.sms_24dp_fill0_wght400_grad0_opsz24),
                        contentDescription = null // decorative element
                    )
                }
                Text(
                    stringResource(
                        R.string.chats
                    ),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Column {
                IconButton1(onClick = { /* do something */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.favorite_24dp_fill0_wght400_grad0_opsz24),
                        contentDescription = null // decorative element
                    )
                }
                Text(
                    stringResource(R.string.swipen),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
            Column {
                IconButton1(onClick = { /* do something */ }) {
                    Icon(
                        painter = painterResource(id = R.drawable.person_24dp_fill0_wght400_grad0_opsz24),
                        contentDescription = null // decorative element
                    )
                }
                Text(
                    stringResource(R.string.profil),
                    modifier = Modifier.align(Alignment.CenterHorizontally),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Medium
                )
            }
        }
    }
}

@Composable
fun ProfileCardWithSwipe(
    uiState: SwipeUiState,
    modifier: Modifier = Modifier,
    draggable: Boolean = true,
    onSwipeLeft: () -> Unit,
    onSwipeRight: () -> Unit
) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }
    val sizePx = with(LocalDensity.current) { 300.dp.toPx() }
    val swipeThreshold = sizePx / 4

    val offsetXState = remember { Animatable(0f) }
    val offsetYState = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        offsetXState.animateTo(0f)
        offsetYState.animateTo(0f)
    }

    val gestureDetector = Modifier.pointerInput(Unit) {
        detectDragGestures(
            onDragEnd = {

                if (offsetX > swipeThreshold) {
                    onSwipeRight()
                }
                if (offsetX < 0) {
                    onSwipeLeft()
                }
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AlertDialogMatch(
    onDismissRequest: () -> Unit,
    onConfirmation: () -> Unit,
    dialogTitle: String,
    dialogText: String,
) {
    AlertDialog(
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}


@Preview(showBackground = true)
@Composable
fun MyScreenPreview() {
    SwipeScreen(viewModel = SwipeViewModel(), navController = rememberNavController())
}

@Composable
fun UseCorrectProfilePictureUnfiltered(uiState: SwipeUiState) {
    if (uiState.indexOfList == 0) {
        Image(
            painter = painterResource(R.drawable.hund1),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }

    if (uiState.indexOfList == 1) {
        Image(
            painter = painterResource(R.drawable.katze2),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }

    if (uiState.indexOfList == 2) {
        Image(
            painter = painterResource(R.drawable.hund3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }

    if (uiState.indexOfList == 3) {
        Image(
            painter = painterResource(R.drawable.katze4),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }

    if (uiState.indexOfList == 4) {
        Image(
            painter = painterResource(R.drawable.hund5),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }

    if (uiState.indexOfList == 5) {
        Image(
            painter = painterResource(R.drawable.katze3),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
        )
    }
}

@Composable
fun CongratulatoryScreen() {
    var showCongrats by remember { mutableStateOf(false) }
    var showConfetti by remember { mutableStateOf(false) }
    var dismissed by remember { mutableStateOf(false)
    }

    // Simulate the event (e.g., game win) after a delay
    LaunchedEffect(Unit) {
        delay(1000) // Delay to simulate the event trigger
        showCongrats = true
        showConfetti = true
    }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (showCongrats) {
            CongratulationsMessage()
        }
        if (showConfetti) {
            ConfettiAnimation()
        }
        if (showCongrats || showConfetti) {
            Button(
                onClick = { dismissed = true },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp)
            ) {
                Text(text = "Dismiss")
            }
        }
    }
}


@Composable
fun CongratulationsMessage() {
    Text(
        text = "It's a match!",
        fontSize = 24.sp,
        color = Color.White,
        modifier = Modifier.fadeInAnimation()
    )
}

@Composable
fun ConfettiAnimation() {
    val infiniteTransition = rememberInfiniteTransition(label = "")
    val offset by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 1000f,
        animationSpec = infiniteRepeatable(
            animation = tween(5000, easing = LinearEasing),
        ), label = ""
    )

    Image(
        painter = painterResource(id = R.drawable.c),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .offset(y = offset.dp)
            .fadeInAnimation()
    )
}

@Composable
fun Modifier.fadeInAnimation(): Modifier {
    val alpha by animateFloatAsState(
        targetValue = 1f,
        animationSpec = tween(durationMillis = 1000), label = ""
    )
    return this.alpha(alpha)
}

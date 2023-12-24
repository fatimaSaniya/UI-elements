@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.uielements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Button
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Slider
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.uielements.ui.theme.UIElementsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIElementsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        Column {
                            ButtonSection()
                        }
                        UserInoutFunction()
                        Example()
                        SwitchMinimalExample()
                        SliderMinimalExample()
                    }
                }
            }
        }
    }
}

@Composable
fun ButtonSection() {
    val scrollState = rememberScrollState()
    Column {
        Text(
            text = "Button in jetpack compose",
            Modifier.padding(top = 16.dp, start = 16.dp)
        )
        Row(
            modifier = Modifier
                .horizontalScroll(scrollState)
                .padding(16.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Outlined.FavoriteBorder, contentDescription = null)

            }
            Button(onClick = {}) {
                Icon(imageVector = Icons.Outlined.Call, contentDescription = null)
                Spacer(modifier = Modifier.width(4.dp))
                Text(text = "Basic button with icon")
            }
            FilledTonalButton(onClick = { }) {
                Text(text = "Tonal button")
            }
            OutlinedButton(onClick = { }) {
                Text(text = "Outline button")
            }
            ElevatedButton(onClick = { }) {
                Text(text = "Elevated button")
            }
            TextButton(onClick = { }) {
                Text(text = "Text button")
            }

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserInoutFunction() {
    val scrollState = rememberScrollState()
    var text by remember { mutableStateOf("Hello") }
    Column {
        Text(
            text = "User input in jetpack compose",
            modifier = Modifier.padding(top = 16.dp, start = 16.dp)
        )
        Column(
            modifier = Modifier
                .padding(16.dp)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {


            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Label") }
            )
            OutlinedTextField(value = text,
                onValueChange = { text = it },
                label = { Text("Label") },
                leadingIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.images),
                        contentDescription = null,
                        modifier = Modifier
                            .size(30.dp)
                            .offset(x = 8.dp)
                    )
                })


            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text("Enter text") },
                maxLines = 2,
                modifier = Modifier.padding(2.dp),
                textStyle = TextStyle(color = Color.Blue, fontWeight = FontWeight.Bold),

                )
            val brush = remember {
                Brush.verticalGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Yellow,
                        Color.Cyan
                    )
                )
            }
            TextField(
                value = text,
                onValueChange = { text = it },
                label = { Text(text = "Customised text") },
                textStyle = TextStyle(brush = brush),
                leadingIcon = {
                    Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                },

                trailingIcon = {
                    IconButton(onClick = { /*TODO*/ }) {

                    }
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = null)
                },
                supportingText = { Text("Don't write anything wrong") },
                isError = true,
                shape = RoundedCornerShape(
                    topEnd = 20.dp,
                    topStart = 16.dp
                )
            )
        }

    }
}

@Composable
fun Example() {
    Text(
        text = "Floating action button",
        modifier = Modifier.padding(start = 16.dp, bottom = 10.dp)
    )
    Row {

        FloatingActionButton(
            onClick = { },
            modifier = Modifier.padding(start = 10.dp, end = 16.dp)
        ) {
            Icon(Icons.Filled.Add, "Floating action button.")
        }
        SmallFloatingActionButton(
            onClick = { },
            modifier = Modifier.padding(end = 10.dp)
        ) {
            Icon(Icons.Filled.Add, "Small floating action button.")
        }
        LargeFloatingActionButton(
            onClick = { },
            shape = RoundedCornerShape(30.dp),
            modifier = Modifier.padding(end = 10.dp)
        ) {
            Icon(Icons.Filled.Add, "Large floating action button")
        }
        ExtendedFloatingActionButton(
            onClick = { },
            icon = { Icon(Icons.Filled.Edit, "Extended floating action button.") },
            text = { Text(text = "Extended FAB") },
            modifier = Modifier.padding(end = 10.dp)
        )
    }
}

@Composable
fun SwitchMinimalExample() {
    var checked by remember { mutableStateOf(true) }
    Switch(checked = checked,
        onCheckedChange = { checked = it },)
}

@Preview
@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Column {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}




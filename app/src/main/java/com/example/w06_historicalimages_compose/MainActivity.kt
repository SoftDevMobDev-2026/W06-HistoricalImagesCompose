package com.example.w06_historicalimages_compose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    var currentImage by remember { mutableStateOf(R.drawable.station) }

    Column(modifier = Modifier.fillMaxSize()) {


        Box {
            Image(
                painter = painterResource(id = currentImage),
                contentDescription = "station",
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .fillMaxWidth()
//                    .weight(10f)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
            verticalAlignment = Alignment.Bottom
        ) {
            Button(
                onClick = { currentImage = R.drawable.station },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Station")
            }

            Button(
                onClick = { currentImage = R.drawable.college },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("College")
            }

            Button(
                onClick = { currentImage = R.drawable.theatre },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Theatre")
            }
            Button(
                onClick = { currentImage = R.drawable.station },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Reset")
            }
        }

        Text(
            text = stringResource(id = R.string.app_name),
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
    }
}

package com.example.w06_historicalimages_compose


import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import android.os.Bundle
import android.util.Log
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivityVM : ComponentActivity() {
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
fun MainScreenVM(viewModel: ImageViewModel = viewModel() ) {
    val currentImage by viewModel.currentImage.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {

        val imageRes = when (currentImage) {
            "station" -> R.drawable.station
            "college" -> R.drawable.college
            "theatre" -> R.drawable.theatre
            else -> R.drawable.station
        }

//        Box {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "station",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .fillMaxWidth()
//                    .weight(10f)
        )
//        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .weight(10f),
        ) {
            Button(
                onClick = { viewModel.selectImage("station") },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Station")
            }

            Button(
                onClick = { viewModel.selectImage("college") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("College")
            }

            Button(
                onClick = { viewModel.selectImage("theatre") },
                modifier = Modifier.weight(1f).fillMaxWidth()
            ) {
                Text("Theatre")
            }
            Button(
                onClick = { viewModel.selectImage("station") },
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

class ImageViewModel : ViewModel(){

    private val _currImage = MutableStateFlow("Station")
    val currentImage : StateFlow<String> = _currImage.asStateFlow()

    fun selectImage(image: String){
        _currImage.value = image
    }
}


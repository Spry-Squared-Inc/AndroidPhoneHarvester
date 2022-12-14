package com.example.androidphoneharvester

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.androidphoneharvester.ui.theme.AndroidPhoneHarvesterTheme
import android.os.Build

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AndroidPhoneHarvesterTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Surface(color = Color.Cyan) {
        Text(text = "data: $name!", modifier = Modifier.padding(24.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AndroidPhoneHarvesterTheme {
        Greeting(currentVersion()) //Build.VERSION.RELEASE_OR_CODENAME)
    }
}

fun currentVersion(): String {
    val release = java.lang.Double.parseDouble(java.lang.String(Build.VERSION.RELEASE).replaceAll("(\\d+[.]\\d+)(.*)", "$1"))
    var codeName = "Unsupported"//below Jelly Bean
    if (release >= 4.1 && release < 4.4)  codeName = "Jelly Bean"
    else if (release < 5)   codeName = "Kit Kat"
    else if (release < 6)   codeName = "Lollipop"
    else if (release < 7)   codeName = "Marshmallow"
    else if (release < 8)   codeName = "Nougat"
    else if (release < 9)   codeName = "Oreo"
    else if (release < 10)  codeName = "Pie"
    else if (release >= 10) codeName = "Android "+(release.toInt())//since API 29 no more candy code names
    return codeName + " v" + release + ", API Level: " + Build.VERSION.SDK_INT
}
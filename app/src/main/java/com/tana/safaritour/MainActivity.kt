package com.tana.safaritour

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tana.safaritour.ui.theme.SafariTourTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafariTourTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TestFonts()
                }
            }
        }
    }
}

@Composable
fun TestFonts() {
    Column() {
        Text(text = "Body 1", style = MaterialTheme.typography.body1)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Body 2", style = MaterialTheme.typography.body2)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Caption", style = MaterialTheme.typography.caption)
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "Button", style = MaterialTheme.typography.button)
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SafariTourTheme {
    }
}
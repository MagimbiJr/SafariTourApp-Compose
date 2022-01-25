package com.tana.safaritour

import android.os.Bundle
import android.view.Window
import android.view.WindowAnimationFrameStats
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.WindowCompat
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.tana.safaritour.navigation.navgraph.SafariTourNavGraph
import com.tana.safaritour.ui.theme.SafariTourTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val systemUiController = rememberSystemUiController()
            val scaffoldState  = rememberScaffoldState()
            val coroutineScope = rememberCoroutineScope()
            val scrollState = rememberScrollState()

            SafariTourTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ProvideWindowInsets() {
                        SafariTourNavGraph(
                            navController = navController,
                            systemUiController = systemUiController,
                            scaffoldState = scaffoldState,
                            coroutineScope = coroutineScope,
                            scrollState = scrollState
                        )
                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SafariTourTheme {
    }
}
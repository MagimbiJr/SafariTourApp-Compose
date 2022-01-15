package com.tana.safaritour.authentication.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.tana.safaritour.R
import com.tana.safaritour.navigation.routes.AuthRoutes
import com.tana.safaritour.ui.components.buttons.PrimaryButton
import com.tana.safaritour.ui.components.buttons.SecondaryButton
import com.tana.safaritour.ui.theme.Cultured
import com.tana.safaritour.ui.theme.RussianViolet

@Composable
fun LandingScreen(
    navController: NavHostController,
    systemUiController: SystemUiController,
    modifier: Modifier = Modifier
) {
    systemUiController.setStatusBarColor(color = Color.Black)
    Box(
        modifier = modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.lion),
            contentDescription = "landing screen",
            modifier = modifier
                .fillMaxSize(),
            contentScale = ContentScale.Crop,
        )
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = RussianViolet.copy(alpha = 0.4f)),
        )
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 12.dp)
        ) {
            Column(
                modifier = modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Safari Tours",
                    style = MaterialTheme.typography.h3,
                    color = Cultured
                )
                Spacer(modifier = modifier.height(8.dp))
                Text(
                    text = "Travel the world and see the most amazing " +
                            "sceneries and nature.",
                    textAlign = TextAlign.Center,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.W500,
                    color = Cultured
                )
            }
            PrimaryButton(
                text = "login",
                onClick = { navController.navigate(AuthRoutes.Login.route) },
                enabled = true
            )
            Spacer(modifier = modifier.height(12.dp))
            SecondaryButton(
                text = "sign up", 
                onClick = { navController.navigate(AuthRoutes.SignUp.route) },
                enabled = true
            )
            Spacer(modifier = modifier.height(60.dp))
        }
    }
}
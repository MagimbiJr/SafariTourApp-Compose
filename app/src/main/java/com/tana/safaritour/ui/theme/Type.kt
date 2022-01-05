package com.tana.safaritour.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.tana.safaritour.R

private val UbuntuBold = FontFamily(Font(R.font.ubuntu_bold))
private val UbuntuMedium = FontFamily( Font(R.font.ubuntu_medium))
private val UbuntuRegular = FontFamily(Font(R.font.ubuntu_regular))
private val UbuntuLight = FontFamily(Font(R.font.ubuntu_light))

// Set of Material typography styles to start with
val Typography = Typography(
    h1 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W400,
        fontSize = 65.sp
    ),
    h2 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W400,
        fontSize = 55.sp
    ),
    h3 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W400,
        fontSize = 45.sp
    ),
    h4 = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W400,
        fontSize = 35.sp
    ),
    h5 = TextStyle(
        fontFamily = UbuntuMedium,
        fontWeight = FontWeight.W300,
        fontSize = 30.sp
    ),
    h6 = TextStyle(
        fontFamily = UbuntuMedium,
        fontWeight = FontWeight.W300,
        fontSize = 25.sp
    ),
    body1 = TextStyle(
        fontFamily = UbuntuLight,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    button = TextStyle(
        fontFamily = UbuntuRegular,
        fontWeight = FontWeight.W600,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = UbuntuLight,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)
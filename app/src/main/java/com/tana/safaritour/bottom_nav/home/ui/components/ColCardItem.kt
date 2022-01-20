package com.tana.safaritour.bottom_nav.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.tana.safaritour.bottom_nav.home.data.Place
import com.tana.safaritour.ui.theme.BoxCardShape

@Composable
fun ColCardItem(
    place: Place,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(BoxCardShape)
    ) {
        val painter = rememberImagePainter(data = place.image)
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Box(
            modifier = modifier
                .background(MaterialTheme.colors.primary)
                .align(Alignment.BottomEnd),
        ) {
            Text(
                text = place.name,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(horizontal = 32.dp, vertical = 12.dp)
            )
        }
    }
}
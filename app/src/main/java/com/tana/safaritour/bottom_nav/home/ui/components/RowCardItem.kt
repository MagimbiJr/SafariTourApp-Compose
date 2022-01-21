package com.tana.safaritour.bottom_nav.home.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.tana.safaritour.bottom_nav.home.data.Place
import com.tana.safaritour.ui.theme.AliceBlue
import com.tana.safaritour.ui.theme.BoxCardShape
import com.tana.safaritour.ui.theme.Cultured
import com.tana.safaritour.ui.theme.RussianViolet

@Composable
fun RowCardItem(
    place: Place,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .width(160.dp)
            .height(220.dp)
            .clip(BoxCardShape)
    ) {
        val painter = rememberImagePainter(data = place.image)
        Image(
            painter = painter,
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(MaterialTheme.colors.primary)
                .align(Alignment.BottomEnd)
        ) {
            Column(
                modifier = modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
            ) {
                Text(
                    text = place.name,
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = modifier.height(4.dp))
                Text(text = place.type)
            }
        }
        
        Card(
            modifier = modifier
                .clip(CircleShape)
                //.align(Alignment.BottomEnd)
                .align(Alignment.TopEnd)
                .clickable {  },
            backgroundColor = Cultured
        ) {
            Icon(
                imageVector = Icons.Filled.FavoriteBorder,
                contentDescription = null,
                modifier = modifier
                    .padding(8.dp),
                tint = RussianViolet
            )
        }
    }
}
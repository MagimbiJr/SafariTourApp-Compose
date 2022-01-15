package com.tana.safaritour.ui.components.buttons

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.ButtonShape

@Composable
fun FederationSignButton(
    text: String,
    image: Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.surface
) {
    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor
    )

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(50.dp)
            .shadow(8.dp, shape = ButtonShape),
        colors = buttonColors,
        shape = ButtonShape
    ) {
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(painter = painterResource(id = image), contentDescription = null)
            Spacer(modifier = modifier.width(12.dp))
            Text(text = text)
        }
    }
}
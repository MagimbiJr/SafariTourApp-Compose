package com.tana.safaritour.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.ButtonShape
import com.tana.safaritour.ui.theme.SafariTourTheme

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.Transparent
) {
    val buttonColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColor
    )
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.button_height))
            .border(width = (2.dp), color = MaterialTheme.colors.primary, shape = ButtonShape),
        enabled = enabled,
        shape = ButtonShape,
        colors = buttonColors
    ) {
        Text(
            text = text.toUpperCase()
        )
    }
}


@Preview(
    name = "Day mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)

@Preview(
    name = "Night mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)

@Composable
fun SecondaryButtonPreview() {
    SafariTourTheme() {
        SecondaryButton(
            text = "Button",
            onClick = { },
            enabled = true
        )
    }
}
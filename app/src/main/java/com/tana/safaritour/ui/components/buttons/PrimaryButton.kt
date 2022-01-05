package com.tana.safaritour.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.ButtonShape
import com.tana.safaritour.ui.theme.SafariTourTheme

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier,
    backgroundColors: Color = MaterialTheme.colors.primary
) {
    val buttonsColors = ButtonDefaults.buttonColors(
        backgroundColor = backgroundColors
    )
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.button_height)),
        enabled = enabled,
        colors = buttonsColors,
        shape = ButtonShape
    ) {
        Text(text = text)
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
fun PrimaryButtonPreview() {
    SafariTourTheme() {
        PrimaryButton(
            text = "Button",
            onClick = { },
            enabled = true
        )
    }
}
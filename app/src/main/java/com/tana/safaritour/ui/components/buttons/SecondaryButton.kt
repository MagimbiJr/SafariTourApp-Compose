package com.tana.safaritour.ui.components.buttons

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.SafariTourTheme

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .height(dimensionResource(id = R.dimen.button_height)),
        enabled = enabled
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
fun SecondaryButtonPreview() {
    SafariTourTheme() {
        SecondaryButton(
            text = "Button",
            onClick = { },
            enabled = true
        )
    }
}
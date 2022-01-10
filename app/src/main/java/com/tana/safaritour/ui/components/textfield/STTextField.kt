package com.tana.safaritour.ui.components.textfield

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.SafariTourTheme
import com.tana.safaritour.ui.theme.TextFieldShape

@Composable
fun STTextField(
    text: String,
    onTextChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String,
    errorMessage: String? = null,
    trailingIcon: @Composable (() -> Unit)? = null,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default
) {
    val textFieldColors = TextFieldDefaults.outlinedTextFieldColors(
        backgroundColor = Color.Transparent
    )
    Column() {
        OutlinedTextField(
            value = text,
            onValueChange = onTextChange,
            modifier = modifier
                .fillMaxWidth()
                //.height(dimensionResource(id = R.dimen.text_field_height))
                .height(60.dp),
            label = { Text(text = label) },
            trailingIcon = trailingIcon,
            isError = (errorMessage != null),
            visualTransformation = visualTransformation,
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            shape = TextFieldShape,
            colors = textFieldColors
        )
        Spacer(modifier = modifier.height(8.dp))
        if (errorMessage != null) {
            Text(
                text = errorMessage,
                color = MaterialTheme.colors.error,
                modifier = modifier
                    .padding(start = 16.dp)
            )
        }
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
fun TextFieldPreview() {
    SafariTourTheme() {
        STTextField(
            text = "",
            onTextChange = {},
            label = "Label"
        )
    }
}
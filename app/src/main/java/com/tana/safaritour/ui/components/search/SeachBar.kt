package com.tana.safaritour.ui.components.search

import android.content.res.Configuration
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tana.safaritour.R
import com.tana.safaritour.ui.theme.ButtonShape
import com.tana.safaritour.ui.theme.SafariTourTheme
import com.tana.safaritour.ui.theme.TextFieldShape

@Composable
fun SearchBar(
    text: String,
    onTextChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    modifier: Modifier = Modifier,
    label: String = "Search",
    backgroundColor: Color = MaterialTheme.colors.secondary
) {
    val textFieldColors = TextFieldDefaults.textFieldColors(
        backgroundColor = backgroundColor,
        textColor = MaterialTheme.colors.onBackground,
        cursorColor = MaterialTheme.colors.onBackground,
        focusedIndicatorColor = Color.Transparent,
        unfocusedIndicatorColor = Color.Transparent
    )
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = text,
            onValueChange = onTextChange,
            placeholder = { Text(text = label) },
            modifier = modifier
                .fillMaxWidth(0.85f)
                .height(50.dp),
            colors = textFieldColors,
            shape = TextFieldShape
        )
        Spacer(modifier = modifier.width(8.dp))
        Card(
            modifier = modifier
                .clickable { onSearch(text) }
                .height(50.dp),
            shape = ButtonShape,
            backgroundColor = MaterialTheme.colors.primary
        ) {
            Icon(
                imageVector = Icons.Sharp.Search,
                contentDescription = "",
                modifier = modifier
                    .padding(horizontal = 12.dp)
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
fun SearchBarPreview() {
    SafariTourTheme() {
        SearchBar(text = "", onTextChange = {}, onSearch = {})
    }
}


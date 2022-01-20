package com.tana.safaritour.bottom_nav.home.ui

import android.content.res.Configuration
import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.google.firebase.auth.FirebaseAuth
import com.tana.safaritour.bottom_nav.home.ui.HomeScreenUiState
import com.tana.safaritour.bottom_nav.home.ui.components.ColCardItem
import com.tana.safaritour.bottom_nav.home.ui.components.RowCardItem
import com.tana.safaritour.ui.components.buttons.PrimaryButton
import com.tana.safaritour.ui.theme.SafariTourTheme

@Composable
fun HomeContent(
    homeScreenUiState: HomeScreenUiState,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (homeScreenUiState.isLoading) {
            CircularProgressIndicator()
        } else {
            Column(
                modifier = modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                GreetingNote(modifier)
                Spacer(modifier = modifier.height(24.dp))
                Places(homeScreenUiState = homeScreenUiState)
                Spacer(modifier = modifier.height(24.dp))
                Categories()
                Spacer(modifier = modifier.height(16.dp))
                PopularPlaces(homeScreenUiState = homeScreenUiState)
            }
        }
    }

}

@Composable
fun Categories(
    modifier: Modifier = Modifier
) {
    val categories = listOf("Related", "Zoos", "Villages", "Parks")
    var selectedItem by remember { mutableStateOf(categories[0]) }
    Text(
        text = "Category",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = modifier.height(16.dp))
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        itemsIndexed(categories) { index, category ->

            Card(
                modifier = modifier
                    .clip(CircleShape)
                    .clickable {
                        selectedItem = categories[index]
                    },
                shape = CircleShape,
                backgroundColor = if (selectedItem == category) MaterialTheme.colors.primary else
                    MaterialTheme.colors.secondary
            ) {
                Text(
                    text = category,
                    modifier = modifier
                        .padding(horizontal = 24.dp, vertical = 8.dp),
                    color = MaterialTheme.colors.onBackground
                )
            }
        }
    }

}

@Composable
fun GreetingNote(modifier: Modifier) {
    Text(
        text = "Hi, Name",
        style = MaterialTheme.typography.h6
    )
    Spacer(modifier = modifier.height(6.dp))
    Row(
        modifier = modifier
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Welcome to",
            fontSize = 22.sp,
            color = Color.DarkGray,
        )
        Spacer(modifier = modifier.width(8.dp))
        Text(
            text = "Safari Tour",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colors.onBackground
        )
    }
}

@Composable
fun Places(
    homeScreenUiState: HomeScreenUiState,

    ) {
    val places = homeScreenUiState.places?.observeAsState(initial = listOf())?.value

    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (places != null) {
            items(places) { place ->
                RowCardItem(place = place)
            }
        }
    }
}

@Composable
fun PopularPlaces(
    homeScreenUiState: HomeScreenUiState,
    modifier: Modifier = Modifier
) {
    val popularPlaces = homeScreenUiState.places?.observeAsState(initial = listOf())?.value
    Row(
        modifier = modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "Popular",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = "See all",
            fontSize = 17.sp,
            modifier = modifier
                .clickable { }
        )
    }
    Spacer(modifier = modifier.height(16.dp))
    Log.d("TAG", "PopularPlaces: $popularPlaces")
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        if (popularPlaces != null) {
            items(popularPlaces) { popularPlace ->
                ColCardItem(place = popularPlace)
            }
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
fun HomeContentPreview() {
    val uiState = HomeScreenUiState()
    SafariTourTheme() {
        Surface() {
            HomeContent(homeScreenUiState = uiState)
        }
    }
}
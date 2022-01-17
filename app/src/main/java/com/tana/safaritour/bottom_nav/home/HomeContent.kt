package com.tana.safaritour.bottom_nav.home

import androidx.compose.runtime.Composable
import com.google.firebase.auth.FirebaseAuth
import com.tana.safaritour.ui.components.buttons.PrimaryButton

@Composable
fun HomeContent() {
    val auth = FirebaseAuth.getInstance()
    PrimaryButton(
        text = "Log out",
        onClick = { auth.signOut() },
        enabled = true
    )
}
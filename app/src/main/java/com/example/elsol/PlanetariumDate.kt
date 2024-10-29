package com.example.elsol

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun PlanetariumDate() {
    Box(modifier = Modifier.statusBarsPadding().navigationBarsPadding()) {
        Button(
            onClick = {}
        ) {
            Text("Download more info")
        }

        Button(
            onClick = {}
        ) {
            Text("Visit Planetarium. Select date")
        }

    }
}
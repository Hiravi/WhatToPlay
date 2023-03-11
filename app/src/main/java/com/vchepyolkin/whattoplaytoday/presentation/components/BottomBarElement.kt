package com.vchepyolkin.whattoplaytoday.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*

import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BottomBarElement(
    imageVector: ImageVector,
    onClick: () -> Unit,
    text: String,
    contentDescription: String,
) {

    Box(
        modifier = Modifier
            .clickable { onClick },
        contentAlignment = Alignment.Center
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = contentDescription
            )
            Text(
                text = text,
                fontSize = 6.sp
            )
        }
    }
}
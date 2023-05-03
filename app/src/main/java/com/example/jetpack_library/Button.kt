package com.example.jetpack_library

import android.util.Log
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.jetpack_library.ui.theme.Shapes


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ButtonGoogle(
    text: String = "Sign in with google...",
    loadingText: String = "Waiting to sign in",
    painter: Painter = painterResource(id = R.drawable.ic_google)
) {
    var isClicked by remember {
        mutableStateOf(false)
    }
    Surface(
        color = MaterialTheme.colors.surface,
        shape = Shapes.medium,
        border = BorderStroke(width = 1.dp, color = Color.LightGray),
        onClick = { isClicked = !isClicked }) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(start = 12.dp, end = 16.dp, top = 12.dp, bottom = 12.dp)
                .animateContentSize(
                    tween(durationMillis = 300, easing = LinearOutSlowInEasing)
                )
        ) {
            Icon(
                painter = painter,
                tint = Color.Unspecified,
                contentDescription = "email"
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(text = if (isClicked) loadingText else text)
            if (isClicked) {
                Spacer(modifier = Modifier.width(10.dp))
                CircularProgressIndicator(
                    modifier = Modifier
                        .height(16.dp)
                        .width(16.dp),
                    strokeWidth = 2.dp
                )
            }

        }
    }
}
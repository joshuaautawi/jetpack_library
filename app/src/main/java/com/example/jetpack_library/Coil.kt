package com.example.jetpack_library

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.ImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
//https://coil-kt.github.io/coil/compose/
@Composable
fun CoilImages() {
    Box(
        modifier = Modifier
            .width(200.dp)
            .height(200.dp),
        contentAlignment = Alignment.Center
    ) {
        val painter =
            rememberAsyncImagePainter(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://i.pinimg.com/originals/9d/1c/a1/9d1ca1bec8a5cc6b1f21082dd542ae34.jpg")
                    .crossfade(true)
                    .transformations(
                        CircleCropTransformation()
                    )
                    .build()


            )
        val painterState = painter.state
        Image(painter = painter, contentDescription = "painter")
        if (painterState is AsyncImagePainter.State.Loading) {
            CircularProgressIndicator()
        }
    }
}
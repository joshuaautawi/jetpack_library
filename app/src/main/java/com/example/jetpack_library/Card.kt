package com.example.jetpack_library

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardExpandable(
    title: String,
    body: String,
    backgroundColor : Color = MaterialTheme.colors.onBackground,
    defaultIsExpandable: Boolean = false,
    animationDuration: Int = 100,
    textColor: Color = MaterialTheme.colors.onSecondary,
    titleFontSize: TextUnit = 20.sp,
    titleFontWeight: FontWeight = FontWeight.Bold,
    bodyFontSize: TextUnit = 20.sp,
    bodyFontWeight: FontWeight = FontWeight.Bold,


    ) {
    var isExpandable by remember {
        mutableStateOf(defaultIsExpandable)
    }
    val rotationState by animateFloatAsState(targetValue = if (isExpandable) 180f else 0f)



    Card(
        modifier = Modifier
            .fillMaxWidth()
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = animationDuration,
                    easing = LinearEasing
                )
            ),
        backgroundColor = backgroundColor,
        shape = RoundedCornerShape(8.dp),
        onClick = { isExpandable = !isExpandable }
    ) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(horizontal = 15.dp, vertical = 2.dp)
            ) {
                Text(
                    text = title,
                    fontSize = titleFontSize,
                    fontWeight = titleFontWeight,
                    color = textColor,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier.weight(6f)
                )
                IconButton(
                    onClick = { isExpandable = !isExpandable },
                    modifier = Modifier
                        .weight(1f)
                        .rotate(rotationState)
                ) {
                    Icon(imageVector = Icons.Default.ArrowDropDown, contentDescription = "arrow", tint = textColor)
                }
            }
            if (isExpandable) {
                Text(
                    text = body,
                    color = textColor,
                    fontSize = bodyFontSize,
                    fontWeight = bodyFontWeight,
                    modifier = Modifier.padding(
                        start = 15.dp,
                        end = 15.dp,
                        top = 0.dp,
                        bottom = 10.dp
                    )
                )
            }

        }
    }
}
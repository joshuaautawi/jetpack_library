package com.example.jetpack_library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FileBasedFontFamily
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//posible option
// text selection , superscript and subscript
@Composable
fun TextCustom(
    value: String,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary,
    fontSize: TextUnit = MaterialTheme.typography.h6.fontSize,
    fontWeight: FontWeight = FontWeight.Normal,
    fontFamily: FontFamily = FontFamily.Default,
    fontStyle: androidx.compose.ui.text.font.FontStyle = androidx.compose.ui.text.font.FontStyle.Normal,
    lineHeight : TextUnit = 0.sp,
    letterSpacing: TextUnit = 0.sp,
    textDecoration: TextDecoration = TextDecoration.None,
    background: Color = MaterialTheme.colors.background,
    padding: Dp = 20.dp,
    textAlign: TextAlign = TextAlign.Left,
    maxLines: Int = 1,
    overflow: TextOverflow = TextOverflow.Clip
) {
    Text(
        text = value,
        modifier = modifier
            .fillMaxWidth()
            .background(background)
            .padding(padding),
        color = color,
        fontSize = fontSize,
        fontWeight = fontWeight,
        fontFamily = fontFamily,
        fontStyle = fontStyle,
        lineHeight = lineHeight,
        letterSpacing = letterSpacing,
        textAlign = textAlign,
        textDecoration = textDecoration,
        maxLines = maxLines,
        overflow = overflow
    )

}


@Composable
fun TextAnnotatedCustom() {
    Text(
        buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colors.primary
                )
            ) {
                append("D")
            }

            append("A")
            append("B")
        }
    )
}

package com.example.jetpack_library

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Email
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp


@Composable
fun TextFieldCommon(
    label: String = "Enter text",
    placeholder: String = "Enter text",
    backgroundColor: Color = MaterialTheme.colors.onBackground,
    textColor: Color = MaterialTheme.colors.onPrimary,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Send,
    maxChar: Int = 10,
) {
    var input by remember {
        mutableStateOf(TextFieldValue())
    }
    TextField(
        value = input,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            placeholderColor = textColor,
            leadingIconColor = textColor,
            trailingIconColor = textColor,
            cursorColor = textColor,
            textColor = textColor
        ),
        onValueChange = {
            if (maxChar >= it.text.length) {
                input = it
            }
        },
        placeholder = { Text(placeholder) },
        modifier = Modifier.padding(10.dp),
        enabled = enabled,
        readOnly = readOnly,
        shape = RoundedCornerShape(10.dp),
        label = { Text(text = label, color = textColor) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onSearch = { }
        ),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "email")
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "check")
            }
        }
    )
}

@Composable
fun TextFieldOutlined(
    label: String = "Enter text",
    backgroundColor: Color = MaterialTheme.colors.onBackground,
    textColor: Color = MaterialTheme.colors.onPrimary,
    enabled: Boolean = true,
    readOnly: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Send,
    modifier: Modifier = Modifier
) {

    var input by remember {
        mutableStateOf("")
    }

    OutlinedTextField(
        value = input,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            placeholderColor = textColor,
            leadingIconColor = textColor,
            trailingIconColor = textColor,
            cursorColor = textColor,
            textColor = textColor
        ),
        onValueChange = { newText ->
            input = newText
        },
        readOnly = readOnly,
        enabled = enabled,
        modifier = modifier.background(backgroundColor),
        label = { Text(text = label, color = textColor) },

        shape = RoundedCornerShape(10.dp),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction
        ),
        keyboardActions = KeyboardActions(
            onSearch = { }
        ),
        leadingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Email, contentDescription = "email")
            }
        },
        trailingIcon = {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(imageVector = Icons.Default.Check, contentDescription = "check")


            }
        }


    )
}

@Composable
fun TextFieldCustom(
    modifier: Modifier = Modifier,
    backgroundColor: Color = MaterialTheme.colors.onSecondary,
    textColor: Color = MaterialTheme.colors.onPrimary,

    ) {

    var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }


    BasicTextField(
        value = textFieldValue,
        onValueChange = { textFieldValue = it },
        modifier = modifier
            .background(backgroundColor)
            .height(60.dp)
            .width(300.dp)
            .padding(horizontal = 10.dp, vertical = 20.dp),
        textStyle = TextStyle(color = textColor, textAlign = TextAlign.Left),
    )


}


@Composable
fun TextFieldPassword(
    placeholder: String = "Password",
    label: String = "Password",
    backgroundColor: Color = MaterialTheme.colors.onBackground,
    textColor: Color = MaterialTheme.colors.onPrimary,

    ) {
    var password by rememberSaveable {
        mutableStateOf("")
    }
    var isVisible by remember {
        mutableStateOf(false)
    }
    var painter: Painter

    if (isVisible) {
        painter = painterResource(id = R.drawable.ic_baseline_visibility_24)
    } else {
        painter = painterResource(id = R.drawable.ic_baseline_visibility_off_24)
    }

    TextField(
        value = password,
        onValueChange = { password = it },
        placeholder = { Text(text = placeholder, color = textColor) },
        label = { Text(text = label, color = textColor) },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = backgroundColor,
            focusedIndicatorColor = Color.Transparent,
            placeholderColor = textColor,
            leadingIconColor = textColor,
            trailingIconColor = textColor,
            cursorColor = textColor,
            textColor = textColor,

            ),


        visualTransformation = if (isVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Send
        ),
        trailingIcon = {
            IconButton(onClick = { isVisible = !isVisible }) {
                Icon(
                    painter = painter,
                    contentDescription = "visibility"
                )
            }
        }


    )
}
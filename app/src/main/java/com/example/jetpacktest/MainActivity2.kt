package com.example.jetpacktest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.SemanticsProperties.EditableText
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpacktest.ui.theme.JetpackTestTheme

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Авторизация",
                        fontWeight = FontWeight.Bold,
                        color = Color.Gray,
                        fontSize = 32.sp
                    )
                    Spacer(modifier = Modifier.height(32.dp))
                    EditableInput(hint = "Логин")
                    Spacer(modifier = Modifier.height(15.dp))
                    EditableInput(hint = "Пароль")
                    Spacer(modifier = Modifier.height(32.dp))
                    Button()
                }

            }


        }
    }
}



@Composable
fun EditableInput(hint: String) {
    var text by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var isPasswordVisible by remember { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if(hint == "Пароль"){
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Red,
                    unfocusedLabelColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Red,
                    disabledLabelColor = Color.Red,
                    focusedLabelColor = Color.Red
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password, imeAction = ImeAction.Done),
                onValueChange = { password = it},
                visualTransformation = if(isPasswordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    IconButton(onClick = { isPasswordVisible = !isPasswordVisible}) {
                        Icon(imageVector = if(isPasswordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff, contentDescription = "Password Toggle")
                    }
                },
                label = {
                    Text(text = hint)},
                singleLine = true)
        }
        else{
            OutlinedTextField(
                modifier = Modifier.fillMaxWidth(),
                value = text,
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color.Red,
                    unfocusedLabelColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    cursorColor = Color.Red,
                    disabledLabelColor = Color.Red,
                    focusedLabelColor = Color.Red
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Ascii, imeAction = ImeAction.Next),
                onValueChange = { text = it},
                trailingIcon = {
                    IconButton(onClick = { text = ""}) {
                        Icon(imageVector = Icons.Filled.Clear, contentDescription = "")
                    }
                },
                label = {
                    Text(text = hint)},
                singleLine = true)
        }

    }
}

@Composable
fun Button(){
    Button(
        onClick = {},
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.125f),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.Black,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(16.dp)
    ){
        Text(
            fontWeight = FontWeight.Bold,
            text = "ВОЙТИ")
    }
}


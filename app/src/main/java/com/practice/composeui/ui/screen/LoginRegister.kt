package com.practice.composeui.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Email
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Lock
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.practice.composeui.R
import com.practice.composeui.ui.theme.Yellow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(navController: NavController) {
    var textEmail by remember { mutableStateOf("") }
    var textPass by remember { mutableStateOf("") }

    Surface {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFFFEA00))
        ) {
            Text(
                modifier = Modifier
                    .padding(top = 80.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth(),
                text = "Login",
                fontSize = 30.sp,
                textAlign = TextAlign.Center,
                fontFamily = FontFamily(Font(R.font.lexend_medium))
            )
            TextField(
                value = textEmail, onValueChange = {textEmail = it}, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(30.dp),
                placeholder = { Text(text = "Email") },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Email, contentDescription = null) },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = textPass,
                onValueChange = {textPass = it},
                modifier = Modifier.align(Alignment.CenterHorizontally),
                placeholder = { Text(text = "Password") },
                leadingIcon = { Icon(imageVector = Icons.Rounded.Lock, contentDescription = null) },
                visualTransformation = PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Button(
                onClick = {navController.navigate("Register Screen")},
                contentPadding = PaddingValues(vertical = 15.dp, horizontal = 20.dp),
                modifier = Modifier
                    .width(220.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 30.dp),
                shape = RoundedCornerShape(10.dp),
                enabled = true,
                colors = ButtonDefaults.buttonColors(Color.Black),
                elevation = ButtonDefaults.buttonElevation(10.dp)
            ) {
                Text(
                    text = "Login",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.lexend_medium))
                )
            }
            Text(
                text = "No Account? Register Here", modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(20.dp),
                fontSize = 16.sp, fontFamily = FontFamily(Font(R.font.lexend_medium))
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 680.dp, start = 60.dp, end = 60.dp, bottom = 0.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            HorizontalDivider(thickness = 2.dp, color = Color.Gray)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen() {
    var textRName by remember { mutableStateOf("") }
    var textRAddress by remember { mutableStateOf("") }
    var textREmail by remember { mutableStateOf("") }
    var textRPass by remember { mutableStateOf("") }
    val checkAgree = remember { mutableStateOf(false) }

    Surface {
        Column(modifier = Modifier.fillMaxSize().background(Color(0xFFFFEA00))) {
            Text(
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 80.dp, start = 20.dp, end = 20.dp, bottom = 0.dp)
                    .fillMaxWidth(),
                text = "Create Your Account",
                fontFamily = FontFamily(Font(R.font.lexend_medium)),
                fontSize = 30.sp, textAlign = TextAlign.Center
            )
            TextField(
                value = textRName, onValueChange = { textRName = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 40.dp, start = 0.dp, end = 0.dp,  bottom = 10.dp),
                placeholder = { Text(text = "Name") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Person,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions.Default,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = textRAddress, onValueChange = { textRAddress = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                placeholder = { Text(text = "Address") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Home,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                keyboardActions = KeyboardActions.Default,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = textREmail, onValueChange = { textREmail = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                placeholder = { Text(text = "Email") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Email,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                keyboardActions = KeyboardActions.Default,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            TextField(
                value = textRPass, onValueChange = { textRPass = it },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(10.dp),
                placeholder = { Text(text = "Password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Rounded.Lock,
                        contentDescription = null
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                keyboardActions = KeyboardActions.Default,
                shape = RoundedCornerShape(20.dp),
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Yellow.copy(alpha = 0.6f),
                    disabledTextColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent
                )
            )
            Row(modifier = Modifier.fillMaxWidth().padding(10.dp).align(Alignment.CenterHorizontally)) {
                Checkbox(
                    modifier = Modifier.padding(top = 0.dp, bottom = 0.dp, start = 30.dp, end = 0.dp),
                    checked = checkAgree.value,
                    onCheckedChange = { checkAgree.value = it },
                    enabled = true,
                    colors = CheckboxDefaults.colors(Color.Black)
                )
                Text(text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color.Black, fontSize = 12.sp
                        )
                    ){
                        append("I read and agree to ")
                    }
                    withStyle(
                        style = SpanStyle(
                            color = Color.Red, fontSize = 14.sp
                        )
                    ){
                        append("Terms & Condition *")
                    }
                },
                    modifier = Modifier.padding(horizontal = 0.dp, vertical = 12.dp),
                    fontFamily = FontFamily(Font(R.font.lexend_medium)),textAlign = TextAlign.Center)
            }
            Button(
                onClick = {},
                contentPadding = PaddingValues(vertical = 15.dp, horizontal = 20.dp),
                modifier = Modifier
                    .width(220.dp)
                    .align(Alignment.CenterHorizontally)
                    .padding(vertical = 30.dp),
                shape = RoundedCornerShape(10.dp),
                enabled = true,
                colors = ButtonDefaults.buttonColors(Color.Black),
                elevation = ButtonDefaults.buttonElevation(10.dp)
            ) {
                Text(
                    text = "Register",
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.lexend_medium))
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 680.dp, start = 60.dp, end = 60.dp, bottom = 0.dp),
            verticalArrangement = Arrangement.Bottom
        ) {
            HorizontalDivider(thickness = 2.dp, color = Color.Gray)
        }
    }
}
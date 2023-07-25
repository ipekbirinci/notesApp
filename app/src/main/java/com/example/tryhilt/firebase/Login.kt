package com.example.tryhilt.firebase

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel?=null
//navigationlar gelecek home ve kayıt ol
){
    val loginUiState=loginViewModel?.loginUiState
    val isError=loginUiState?.loginError!=null
    val context= LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment =Alignment.CenterHorizontally) {
        Text(text="Login",
            style = MaterialTheme.typography.headlineSmall,
            color=MaterialTheme.colorScheme.primary
        )
        if(isError){
            Text(text=loginUiState?.loginError?:"unknown error",
            color = Color.Red)
        }

        OutlinedTextField(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginUiState?.userName?:"",
            onValueChange ={loginViewModel?.onUserNameChange(it)}, leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null )
            }, label = {
                Text(text = "Email")
            }, isError = isError )

        OutlinedTextField(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginUiState?.password?:"",
            onValueChange ={loginViewModel?.onPasswordChange(it)}, leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null )
            }, label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError )
        Button(onClick = { loginViewModel?.loginUser(context)}) {

            Text(text = "SignIn")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,){
            Text(text="Don't have an account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { /*navigate*/ }) {
                Text(text = "Sign Up")
                
            }
        }
        if(loginUiState?.isLoading==true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if(loginViewModel?.hasUser==true){
                //navigate yapılcak
            }
        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(
    loginViewModel: LoginViewModel?=null
//navigationlar gelecek giriş yap
){
    val loginUiState=loginViewModel?.loginUiState
    val isError=loginUiState?.signUpError!=null
    val context= LocalContext.current
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment =Alignment.CenterHorizontally) {
        Text(text="Sign Up",
            style = MaterialTheme.typography.headlineSmall,
            color=MaterialTheme.colorScheme.primary
        )
        if(isError){
            Text(text=loginUiState?.signUpError?:"unknown error",
                color = Color.Red)
        }

        OutlinedTextField(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginUiState?.userNameSignUp?:"",
            onValueChange ={loginViewModel?.onUserNameChangeSignUp(it)}, leadingIcon = {
                Icon(imageVector = Icons.Default.Email, contentDescription = null )
            }, label = {
                Text(text = "Email")
            }, isError = isError )

        OutlinedTextField(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginUiState?.passwordSignUp?:"",
            onValueChange ={loginViewModel?.onPasswordChangeSignUp(it)}, leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null )
            }, label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError )
        OutlinedTextField(modifier= Modifier
            .fillMaxWidth()
            .padding(16.dp),
            value = loginUiState?.confirmpasswordSignUp?:"",
            onValueChange ={loginViewModel?.onConfirmPasswordChange(it)}, leadingIcon = {
                Icon(imageVector = Icons.Default.Lock, contentDescription = null )
            }, label = {
                Text(text = "Confirm Password")
            },
            visualTransformation = PasswordVisualTransformation(),
            isError = isError )
        Button(onClick = { loginViewModel?.createUser(context)}) {

            Text(text = "Sign In")
        }

        Spacer(modifier = Modifier.size(16.dp))

        Row(modifier=Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center,){
            Text(text="Already have an account?")
            Spacer(modifier = Modifier.size(8.dp))
            TextButton(onClick = { /*navigate*/ }) {
                Text(text = "Sign In")

            }
        }
        if(loginUiState?.isLoading==true){
            CircularProgressIndicator()
        }

        LaunchedEffect(key1 = loginViewModel?.hasUser){
            if(loginViewModel?.hasUser==true){
                //navigate yapılcak
            }
        }

    }

}

@Preview(showSystemUi = true)
@Composable
fun PrevLoginScreen(){

    LoginScreen()

}

@Preview(showSystemUi = true)
@Composable
fun PrevSignUpScreen(){

    SignUpScreen()

}
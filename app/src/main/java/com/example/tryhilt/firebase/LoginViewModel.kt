package com.example.tryhilt.firebase

import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.grpc.Context
import kotlinx.coroutines.launch
import java.lang.Exception
import java.lang.IllegalArgumentException
import kotlin.math.log

class LoginViewModel (
    private val repository: AuthRepository= AuthRepository()
           ):ViewModel(){

            val currentUser=repository.currentUser
            val hasUser:Boolean
            get()=repository.hasUser()

    var loginUiState by mutableStateOf(LoginUiState())
        private set

    fun onUserNameChange(userName:String){
        loginUiState=loginUiState.copy(userName = userName)
    }
    fun onUserNameChangeSignUp(userName:String){
        loginUiState=loginUiState.copy(userNameSignUp = userName)
    }
    fun onPasswordChange(password:String){
        loginUiState=loginUiState.copy(password = password)
    }
    fun onPasswordChangeSignUp(password:String){
        loginUiState=loginUiState.copy(passwordSignUp = password)

    }
    fun onConfirmPasswordChange(password:String){
        loginUiState=loginUiState.copy(confirmpasswordSignUp = password)
    }


    private fun validateLoginForm()=
        loginUiState.userName.isNotBlank()&&
                loginUiState.password.isNotBlank()

    private fun validateSignUpForm()=
        loginUiState.userNameSignUp.isNotBlank()&&
                loginUiState.passwordSignUp.isNotBlank()&&
                loginUiState.confirmpasswordSignUp.isNotBlank()


    fun createUser(context:Context)=viewModelScope.launch {
        try{
            if (!validateLoginForm()){
                throw IllegalArgumentException("email and password can not be empty")
            }
            loginUiState=loginUiState.copy(isLoading = true)
            if(loginUiState.passwordSignUp!=
                loginUiState.confirmpasswordSignUp){
                throw IllegalArgumentException("password do not match")
            }
            loginUiState=loginUiState.copy(signUpError = null)
            repository.createUser(
                loginUiState.userNameSignUp,
                loginUiState.passwordSignUp
            ){
                isSuccesful->
                if(isSuccesful){
                   /* Toast.makeText(
                        context,
                        "success login",
                        Toast.LENGTH_SHORT
                    ).show()*/
                    loginUiState=loginUiState.copy(isSuccessLogin = true)
                }else{
                    /*Toast.makeText(
                        context,
                        "fail login",
                        Toast.LENGTH_SHORT
                    ).show()*/
                    loginUiState=loginUiState.copy(isSuccessLogin = false)
                }
            }


        }catch (e:Exception){

            loginUiState=loginUiState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()

        }finally {
            loginUiState=loginUiState.copy(isLoading = false)
        }
    }
    fun loginUser(context:Context)=viewModelScope.launch {
        try{
            if (!validateLoginForm()){
                throw IllegalArgumentException("email and password can not be empty")
            }
            loginUiState=loginUiState.copy(isLoading = true)
            loginUiState=loginUiState.copy(loginError = null)
            repository.login(
                loginUiState.userName,
                loginUiState.password
            ){
                    isSuccesful->
                if(isSuccesful){
                    /* Toast.makeText(
                         context,
                         "success login",
                         Toast.LENGTH_SHORT
                     ).show()*/
                    loginUiState=loginUiState.copy(isSuccessLogin = true)
                }else{
                    /*Toast.makeText(
                        context,
                        "fail login",
                        Toast.LENGTH_SHORT
                    ).show()*/
                    loginUiState=loginUiState.copy(isSuccessLogin = false)
                }
            }


        }catch (e:Exception){

            loginUiState=loginUiState.copy(loginError = e.localizedMessage)
            e.printStackTrace()

        }finally {
            loginUiState=loginUiState.copy(isLoading = false)
        }
    }













}

data class LoginUiState(
    val userName:String=" ",
    val password:String=" ",
    val userNameSignUp:String=" ",
    val passwordSignUp:String=" ",
    val confirmpasswordSignUp:String=" ",
    val isLoading:Boolean=false,
    val isSuccessLogin:Boolean=false,
    val signUpError:String?=null,
    val loginError:String?=null

)
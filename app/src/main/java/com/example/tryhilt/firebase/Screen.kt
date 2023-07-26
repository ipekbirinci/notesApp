package com.example.tryhilt.firebase

sealed class Screen(
    val route:String
){
    object SignIn: Screen(route = "signin_screen")
    object SignUp: Screen(route = "signup_screen")
    object GoBack:Screen(route="backsignin_screen")
}
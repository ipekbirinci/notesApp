package com.example.tryhilt.firebase

import android.content.Intent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.tryhilt.MainActivity


@Composable
fun SetUpNavGraph(
    startDestination:String,
    navController: NavHostController
) {
    NavHost(navController = navController, startDestination=startDestination){

        composable(route = Screen.SignIn.route){

            LoginScreen(
                navigateToSignUp = {
                    navController.navigate(Screen.SignUp.route)
                }

            )

        }
        signupRoute()
        backSignInRoute()

    }

}



fun NavGraphBuilder.signupRoute(){
    composable(route = Screen.SignUp.route){

        SignUpScreen()
    }
}

fun NavGraphBuilder.backSignInRoute(){
    composable(route = Screen.GoBack.route){

       // LoginScreen()
    }
}


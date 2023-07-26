package com.example.tryhilt.sign

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.tryhilt.firebase.Screen
import com.example.tryhilt.firebase.SetUpNavGraph
import com.example.tryhilt.sign.ui.theme.TryHiltTheme

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController= rememberNavController()

            SetUpNavGraph(startDestination = getStartDestination(), navController = navController)

        }
    }
}

private fun getStartDestination():String{

    //kullanıcı giriş yapıp yapmadığı
    return Screen.SignIn.route
}

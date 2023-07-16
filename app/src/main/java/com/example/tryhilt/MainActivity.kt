package com.example.tryhilt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: MainActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val randomColor = Color.rgb(Random.nextInt(0,255),Random.nextInt(0,255),Random.nextInt(0,255))
//        val a = CardView(this)
//        a.setBackgroundColor(randomColor)
       

    }
}
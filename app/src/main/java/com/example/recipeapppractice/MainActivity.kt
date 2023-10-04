package com.example.recipeapppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.recipeapppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialization of viewBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        val mainView = binding.root
        super.onCreate(savedInstanceState)
        // Showing Splash Screen
        Thread.sleep(1000)
        installSplashScreen()
        // Showing MainActivity
        setContentView(mainView)

        quitApp()
    }
    // Logic of exit button
    fun quitApp() = with(binding){
        btnExit.setOnClickListener{
            finish()
        }
    }
}
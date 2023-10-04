package com.example.recipeapppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapppractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var recipeRecyclerView: RecyclerView
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
        recipeRecyclerView = binding.rvRecipes
        val recipes = createRecipeList()
        val adapter = RecipeAdapter(recipes)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.adapter = adapter


        quitApp()
    }
    // Logic of exit button
    fun quitApp() = with(binding){
        btnExit.setOnClickListener{
            finish()
        }
    }

    fun createRecipeList() : List<Recipes> {
        val recipe1 = Recipes(
            name = "Бебра",
            imgSource = "",
            difficulty = "Сложно",
            type = "Обед",
            time = "За 2 часа"
        )
        return listOf(recipe1)
    }
}
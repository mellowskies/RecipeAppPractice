package com.example.recipeapppractice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapppractice.adapters.RecipeAdapter
import com.example.recipeapppractice.adapters.RecipeIngredientsAdapter
import com.example.recipeapppractice.databinding.ActivityMainBinding
import com.example.recipeapppractice.dataclasses.Recipes

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
        // Showing RecyclerView
        recipeRecyclerView = binding.rvRecipes
        val recipes = createRecipeList()
        val adapter = RecipeAdapter(recipes)
        recipeRecyclerView.layoutManager = LinearLayoutManager(this)
        recipeRecyclerView.adapter = adapter

        quitApp()
    }
    // Logic of exit button
    private fun quitApp() = with(binding){
        btnExit.setOnClickListener{
            finish()
        }
    }

// Create list of recipes
    private fun createRecipeList() : List<Recipes> {
        val recipes = listOf(
            Recipes(
                name = "Французскиe круасаны\n с шоколадным\n соусом",
                imgSource = R.drawable.testfood,
                difficulty = "Простой",
                type = "Завтрак",
                time = "За 1 час"
            ),
            Recipes(
                name = "Пряный тыквенный суп",
                imgSource = R.drawable.soup,
                difficulty = "Продвинут",
                type = "Суп",
                time = "За 2 часа"
            ),
            Recipes(
                name = "Греческая тарелка\n с инжиром и беконом",
                imgSource = R.drawable.buckwheat,
                difficulty = "Простой",
                type = "Завтрак",
                time = "За 30 мин"
            ),
            // Since I can't code the rest of the list just holds the elements on the right place in recyclerview
            Recipes(
                name = "",
                imgSource = R.drawable.list_dot,
                difficulty = "",
                type = "",
                time = ""
            ),
            Recipes(
                name = "Греческая тарелка\n с инжиром и беконом",
                imgSource = R.drawable.buckwheat,
                difficulty = "Простой",
                type = "Завтрак",
                time = "За 30 мин"
            ),
        )
        return recipes
    }

}
package com.example.recipeapppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.recipeapppractice.adapters.vpAdapter
import com.example.recipeapppractice.databinding.ActivityRecipeInfoBinding
import com.example.recipeapppractice.fragments.IngredientsFragment
import com.example.recipeapppractice.fragments.RecipeFragment

class RecipeInfoActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecipeInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding){
        val adapter = vpAdapter(supportFragmentManager)
        adapter.addFragment(IngredientsFragment(), "Ингредиенты")
        adapter.addFragment(RecipeFragment(), "Рецепт")
        vp.adapter = adapter
        tabLayout.setupWithViewPager(vp)
    }
}
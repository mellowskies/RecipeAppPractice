package com.example.recipeapppractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import com.example.recipeapppractice.databinding.ActivityRecipeInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class RecipeInfoActivity : AppCompatActivity() {

    private val fList = listOf(
        IngredientsFragment.newInstance(),
        RecipeFragment.newInstance()
    )

    private val tList = listOf(
        "Ingredients",
        "Recipe"
    )

    private lateinit var binding: ActivityRecipeInfoBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecipeInfoBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() = with(binding){
//        val adapter = vpAdapter(supportFragmentManager, fList)
//        vp.adapter = adapter
//        TabLayoutMediator(tabLayout, vp){ tab, pos ->
//            tab.text = tList[pos]
//        }.attach()
        val adapter = vpAdapter(supportFragmentManager)
        adapter.addFragment(IngredientsFragment(), "Ингредиенты")
        adapter.addFragment(RecipeFragment(), "Рецепт")
        vp.adapter = adapter
        tabLayout.setupWithViewPager(vp)
    }
}
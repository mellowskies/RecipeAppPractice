package com.example.recipeapppractice.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recipeapppractice.dataclasses.RecipeIngredients
import com.example.recipeapppractice.adapters.RecipeIngredientsAdapter
import com.example.recipeapppractice.databinding.FragmentIngredientsBinding

class IngredientsFragment : Fragment() {

    private lateinit var binding: FragmentIngredientsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentIngredientsBinding.inflate(LayoutInflater.from(context))
        // Inflate the layout for this fragment
        init()
        return binding.root
//        return inflater.inflate(R.layout.fragment_ingredients, container, false)
    }

    private fun init() = with(binding){
        rvIngredients.layoutManager = LinearLayoutManager(requireContext())
        rvIngredients.adapter = RecipeIngredientsAdapter(createIngredientsList())
    }

    private fun createIngredientsList() : List<RecipeIngredients>{
        val ingredients = listOf(
            RecipeIngredients(
                ingredient = "Тыква",
                weight = "1 кг"
            ),
            RecipeIngredients(
                ingredient = "Лук",
                weight = "1 кг"
            ),
            RecipeIngredients(
                ingredient = "Чеснок",
                weight = "1 шт"
            ),
            RecipeIngredients(
                ingredient = "Сливки",
                weight = "0,5 л"
            )
        )
        return ingredients
    }

    companion object {
        @JvmStatic
        fun newInstance() = IngredientsFragment()
    }
}
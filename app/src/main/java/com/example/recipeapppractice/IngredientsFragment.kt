package com.example.recipeapppractice

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler
import com.example.recipeapppractice.databinding.ActivityRecipeInfoBinding

class IngredientsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        init()
        return inflater.inflate(R.layout.fragment_ingredients, container, false)
    }

    private fun init(){
        val ingredients = createIngredientsList()
        val rvIng = view?.findViewById<RecyclerView>(R.id.rvIngredients)!!

//        recipeIngredientsRecyclerView = view?.findViewById(R.id.rvIngredients)!!
        rvIng.layoutManager = LinearLayoutManager(requireContext())
        rvIng.adapter = RecipeIngredientsAdapter(ingredients)
    }
    private fun createIngredientsList() : List<RecipeIngredients>{
        val ingredients = listOf(
            RecipeIngredients(
                ingredient = "Тыква",
                weight = "1 кг"
            )
        )
        return ingredients
    }

    companion object {
        @JvmStatic
        fun newInstance() = IngredientsFragment()
    }
}
package com.example.recipeapppractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeIngredientsAdapter(val ingredients: List<RecipeIngredients>) : RecyclerView.Adapter<RecipeIngredientsAdapter.RecipeIngredientsViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeIngredientsViewHolder {
//        val binding = RecipeIngredientsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_ingredients_item, parent, false)
        return RecipeIngredientsViewHolder(view)
    }


    override fun onBindViewHolder(
        holder: RecipeIngredientsViewHolder,
        position: Int
    ) {
        val ingredient = ingredients[position]
        holder.bind(ingredient)
    }

    override fun getItemCount(): Int {
        return ingredients.size
    }

    inner class RecipeIngredientsViewHolder(private val itemView: View) : RecyclerView.ViewHolder(itemView){
        val ingredientName = itemView.findViewById<TextView>(R.id.tvIngredientName)
        val weight = itemView.findViewById<TextView>(R.id.tvWeight)
            fun bind(ingredients: RecipeIngredients){
                ingredientName.text = ingredients.ingredient
                weight.text = ingredients.weight
            }
    }
}
package com.example.recipeapppractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapppractice.databinding.RecipeItemBinding

class RecipeAdapter(val recipes: List<Recipes>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private lateinit var binding : RecipeItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeAdapter.RecipeViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecipeAdapter.RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(recipes: Recipes) = with(binding){
            tvFoodName.text = recipes.name
//            ivFoodImage.
            tvFoodDifficulty.text = recipes.difficulty
            tvFoodType.text = recipes.type
            tvFoodTime.text = recipes.time
        }
    }

}
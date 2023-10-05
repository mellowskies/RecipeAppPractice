package com.example.recipeapppractice

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapppractice.databinding.RecipeItemBinding
import com.squareup.picasso.Picasso

class RecipeAdapter(val recipes: List<Recipes>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
//    private lateinit var binding : RecipeItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        val binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class RecipeViewHolder(private val binding: RecipeItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(recipes: Recipes) = with(binding){
            tvFoodName.text = recipes.name
            Picasso.get().load(recipes.imgSource).into(ivFoodImage)
            tvFoodDifficulty.text = recipes.difficulty
            tvFoodType.text = recipes.type
            tvFoodTime.text = recipes.time
        }
    }

}
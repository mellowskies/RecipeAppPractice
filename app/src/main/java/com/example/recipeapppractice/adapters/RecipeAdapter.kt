package com.example.recipeapppractice.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.recipeapppractice.RecipeInfoActivity
import com.example.recipeapppractice.dataclasses.Recipes
import com.example.recipeapppractice.databinding.RecipeItemBinding
import com.squareup.picasso.Picasso

class RecipeAdapter(val recipes: List<Recipes>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
    private lateinit var binding : RecipeItemBinding
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecipeViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.recipe_item, parent, false)
        val binding = RecipeItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//        val showRecipeInfo: Button = binding.btnShow
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
        holder.btnShowRecipeInfo.setOnClickListener{


            val position = holder.position
            when (position){
                0 -> {

                }
                1 -> {
                    val intent = Intent(holder.itemView.context, RecipeInfoActivity::class.java)
                    holder.itemView.context.startActivity(intent)
                }
                2 -> {

                }
            }
        }
    }


    override fun getItemCount(): Int {
        return recipes.size
    }

    inner class RecipeViewHolder(private val binding: RecipeItemBinding) : RecyclerView.ViewHolder(binding.root){
        val btnShowRecipeInfo: Button = binding.btnShow
        fun bind(recipes: Recipes) = with(binding){
            tvFoodName.text = recipes.name
            Picasso.get().load(recipes.imgSource).into(ivFoodImage)
            tvFoodDifficulty.text = recipes.difficulty
            tvFoodType.text = recipes.type
            tvFoodTime.text = recipes.time
        }
    }

}
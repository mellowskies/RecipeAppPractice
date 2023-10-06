package com.example.recipeapppractice.dataclasses

import android.graphics.drawable.Drawable

data class Recipes(
    val name: String,
    val imgSource: Int,
    val difficulty: String,
    val type: String,
    val time: String
)

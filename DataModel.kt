package com.example.recipefinderapp.data

// use https://app.quicktype.io/ to generate data models from Api response Json
data class RecipePayload (
    val title: String,
    val version: Double,
    val href: String,
    val results: ArrayList<Recipe>
)

data class Recipe (
    val title: String,
    val href: String,
    val ingredients: String,
    val thumbnail: String
)

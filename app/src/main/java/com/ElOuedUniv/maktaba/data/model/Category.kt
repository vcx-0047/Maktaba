package com.ElOuedUniv.maktaba.data.model

data class Category(
    val id: Int,
    val name: String,
    val description: String,
    val iconRes: Int  // Drawable resource ID for the category icon
)
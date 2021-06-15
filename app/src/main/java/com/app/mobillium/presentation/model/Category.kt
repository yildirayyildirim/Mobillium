package com.app.mobillium.presentation.model

data class Category(
    val children: List<Children>,
    val cover: Cover,
    val id: Int,
    val logo: Logo,
    val name: String,
    val order: Int,
    val parent_category: Any,
    val parent_id: Any
)
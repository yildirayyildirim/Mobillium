package com.app.mobillium.presentation.model

data class ParentCategory(
    val id: Int,
    val name: String,
    val order: Int,
    val parent_category: Any,
    val parent_id: Any
)
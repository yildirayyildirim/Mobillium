package com.app.mobillium.core.base

data class BaseModel<T>(
    val type: String,
    val title: String,
    val featured: List<T>,
    val products: List<T>,
    val categories: List<T>,
    val collections: List<T>,
    val shops: List<T>
)
package com.app.mobillium.presentation.model

import com.app.mobillium.core.base.BaseModel

data class ResultModelItem(
    val categories: List<Category>,
    val collections: List<Collection>,
    val featured: List<Featured>,
    val products: List<Product>,
    val shops: List<Shop>,
) : BaseModel()
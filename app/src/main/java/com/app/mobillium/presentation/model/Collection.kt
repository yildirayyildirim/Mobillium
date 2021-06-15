package com.app.mobillium.presentation.model

data class Collection(
    val cover: Cover,
    val definition: String,
    val end: Any,
    val id: Int,
    val logo: Logo,
    val share_url: String,
    val start: String,
    val title: String
)
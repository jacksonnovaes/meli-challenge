package com.challencg.product_api.domain.product

import java.util.UUID

data class Product(

    val id: UUID? = null,
    val name: String,
    val categoryId: Long?
)
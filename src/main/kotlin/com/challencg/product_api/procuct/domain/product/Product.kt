package com.challencg.product_api.procuct.domain.product

import java.util.UUID

data class Product(

    val id: UUID,
    val name: String,
    val catego: Long?
)
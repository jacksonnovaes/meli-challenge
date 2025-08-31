package com.challencg.product_api.domain.product

import com.challencg.product_api.adpters.inbound.dto.response.ProductResponseDTO


data class Product(

    val id: Long? = null,
    val name: String,
    val category: Category?
)
fun Product.toResponseDTO(): ProductResponseDTO =
    ProductResponseDTO(
        id = this.id,
        name = this.name,
        category = this.category!!.toResponseDTO()
    )
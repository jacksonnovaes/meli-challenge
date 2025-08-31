package com.challencg.product_api.adpters.inbound.dto.response

import com.challencg.product_api.domain.product.Category

data class CategoryResponseDTO(
    val id: Long?,
    val name: String,
    val categoriaPai: Category?
)
fun CategoryResponseDTO.toDomain(): Category =
    Category(
        id = this.id,
        name = this.name,
        categoriaPai = this.categoriaPai
    )

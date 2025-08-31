package com.challencg.product_api.adpters.inbound.dto.request

import com.challencg.product_api.domain.product.Category

data class CategoryRequestDTO(
    val name: String
)

fun CategoryRequestDTO.toDomain(): Category =
    Category(
        name = this.name,
        id = null,
        categoriaPai = null
    )

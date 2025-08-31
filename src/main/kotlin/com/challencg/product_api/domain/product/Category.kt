package com.challencg.product_api.domain.product

import com.challencg.product_api.adpters.inbound.dto.response.CategoryResponseDTO
import com.challencg.product_api.adpters.outbound.entities.CategoryEntity

data class Category(
    val id: Long? = null,
    val name: String,
    val categoriaPai: Category?
)
fun Category.toResponseDTO(): CategoryResponseDTO =
    CategoryResponseDTO(
        id = this.id,
        name = this.name,
        categoriaPai = this.categoriaPai
    )

fun Category.toEntity(): CategoryEntity =
    CategoryEntity(
        id = this.id,
        name = this.name,
        categoriaPai = this.categoriaPai?.toEntity()
    )
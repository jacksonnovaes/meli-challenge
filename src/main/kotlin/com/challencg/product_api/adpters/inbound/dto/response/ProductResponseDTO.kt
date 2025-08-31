package com.challencg.product_api.adpters.inbound.dto.response

data class ProductResponseDTO(

    val id: Long?,
    val name: String,
    val category: CategoryResponseDTO
)
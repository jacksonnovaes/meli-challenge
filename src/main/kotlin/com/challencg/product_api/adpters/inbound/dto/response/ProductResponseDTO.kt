package com.challencg.product_api.adpters.inbound.dto.response

import java.math.BigDecimal

data class ProductResponseDTO(

    val id: Long?,
    val name: String,
    val descricao: String = "",
    val rate: Float = 0.0F,
    val price: BigDecimal,
    val category: CategoryResponseDTO
)
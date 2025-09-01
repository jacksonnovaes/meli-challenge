package com.challencg.product_api.domain.product

import com.challencg.product_api.adpters.inbound.dto.response.ProductResponseDTO
import java.math.BigDecimal


data class Product(

    val id: Long? = null,
    val name: String,
    val descricao: String = "",
    val rate: Float = 0.0F,
    val price: BigDecimal,
    val category: Category?
)
fun Product.toResponseDTO(): ProductResponseDTO =
    ProductResponseDTO(
        id = this.id,
        name = this.name,
        category = this.category!!.toResponseDTO(),
        descricao = this.descricao,
        rate = this.rate,
        price = this.price
    )
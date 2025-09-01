package com.challencg.product_api.adpters.inbound.dto.request

import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.Product
import java.math.BigDecimal

data class ProductRequestDTO(

    val name: String,
    val descricao: String = "",
    val rate: Float = 0.0F,
    val price: BigDecimal,
    val categoryId: Long?

)
fun ProductRequestDTO.toDomain(): Product =
    Product(
        id = null,
        name = this.name,
        category = this.categoryId?.let {
            Category(
                id = it,
                name = "",
                categoriaPai = null
            )
        },
        descricao = this.descricao,
        rate = this.rate,
        price = this.price
    )

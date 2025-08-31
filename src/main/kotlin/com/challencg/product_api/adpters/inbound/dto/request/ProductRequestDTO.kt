package com.challencg.product_api.adpters.inbound.dto.request

import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.Product

data class ProductRequestDTO(

    val name: String,
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
        }
    )

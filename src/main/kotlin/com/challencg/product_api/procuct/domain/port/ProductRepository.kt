package com.challencg.product_api.procuct.domain.port

import com.challencg.product_api.procuct.domain.product.Product
import java.util.Optional
import java.util.UUID

interface ProductRepository {

    fun salvar(product: Product): Product

    fun findById(id: UUID): Optional<Product>
}
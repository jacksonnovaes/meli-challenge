package com.challencg.product_api.procuct.domain.product

import java.util.UUID

interface ProductRepository {

    fun save(product: Product): Product

    fun findById(id: UUID): Product

    fun findAll(): List<Product>
}
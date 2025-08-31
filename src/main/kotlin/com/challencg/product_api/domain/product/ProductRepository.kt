package com.challencg.product_api.domain.product

interface ProductRepository {

    fun save(product: Product): Product

    fun findById(id: Long): Product?

    fun findAll(): List<Product>
}
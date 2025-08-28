package com.challencg.product_api.application.usecases

import com.challencg.product_api.domain.product.Product

import java.util.UUID

interface ProductUseCases {

    fun save(product: Product): Product

    fun detailProduct(id: UUID): Product?
}
package com.challencg.product_api.application.usecases

import com.challencg.product_api.domain.product.Product

interface ProductUseCases {

    fun save(product: Product): Product

    fun detailProduct(id: Long): Product?
}
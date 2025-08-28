package com.challencg.product_api.application.usecases.impl

import com.challencg.product_api.application.usecases.ProductUseCases
import com.challencg.product_api.domain.product.Product
import com.challencg.product_api.domain.product.ProductRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProductUseCaseImpl(
    private val productRepository: ProductRepository
): ProductUseCases {
    override fun save(product: Product): Product {
      return productRepository.save(product)
    }

    override fun detailProduct(id: UUID): Product? {
       return productRepository.findById(id)
    }
}
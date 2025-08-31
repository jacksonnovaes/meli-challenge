package com.challencg.product_api.application.usecases.impl

import com.challencg.product_api.application.usecases.ProductUseCases
import com.challencg.product_api.domain.product.CategoriaRepository
import com.challencg.product_api.domain.product.Product
import com.challencg.product_api.domain.product.ProductRepository
import com.challencg.product_api.infrastructure.exceptions.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class ProductUseCaseImpl(
    private val productRepository: ProductRepository,
    private val categoriaRepository: CategoriaRepository
): ProductUseCases {
    override fun save(product: Product): Product {
         categoriaRepository.findById(product.category?.id!!).orElseThrow {
             throw EntityNotFoundException("categoria nao encontrada")
         }

      return productRepository.save(product)
    }

    override fun detailProduct(id: Long): Product? {
       return productRepository.findById(id)
    }
}
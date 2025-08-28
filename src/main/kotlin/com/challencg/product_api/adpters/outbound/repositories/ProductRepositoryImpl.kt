package com.challencg.product_api.adpters.outbound.repositories

import com.challencg.product_api.adpters.outbound.entities.ProductEntity
import com.challencg.product_api.domain.product.Product
import com.challencg.product_api.domain.product.ProductRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository
) : ProductRepository {
    override fun save(product: Product): Product {
        val producttoSave = ProductEntity(
            id = null,
            name = product.name,
            category = product.categoryId
        )

        val newProduct = jpaProductRepository.save(producttoSave)
        return Product(
            newProduct.id!!,
            newProduct.name,
            newProduct.category
        )
    }

    override fun findById(id: UUID): Product? {
        return jpaProductRepository.findById(id).map { it
            Product(
                it.id!!,
                it.name,
                it.category
            )
        }.orElse(null)
    }

    override fun findAll(): List<Product> {
       return jpaProductRepository.findAll().map { it ->
           Product(
               it.id,
               it.name,
               it.category
           )
       }
    }

}
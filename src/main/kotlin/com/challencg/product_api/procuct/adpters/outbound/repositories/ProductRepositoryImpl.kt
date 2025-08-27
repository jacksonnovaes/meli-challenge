package com.challencg.product_api.procuct.adpters.outbound.repositories

import com.challencg.product_api.procuct.adpters.outbound.entities.ProductEntity
import com.challencg.product_api.procuct.domain.port.ProductRepository
import com.challencg.product_api.procuct.domain.product.Product
import java.util.Optional
import java.util.UUID

class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository
) : ProductRepository {
    override fun salvar(product: Product): Product {
        val producttoSave = ProductEntity(
            id = null,
            name = product.name,
            category = product.catego
        )

        val newProduct = jpaProductRepository.save(producttoSave)
        return Product(
            newProduct.id!!,
            newProduct.name,
            newProduct.category
        )
    }

    override fun findById(id: UUID): Optional<Product> {
        return jpaProductRepository.findById(id).map { it
            Product(
                it.id!!,
                it.name,
                it.category
            )
        }
    }

}
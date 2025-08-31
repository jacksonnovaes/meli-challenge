package com.challencg.product_api.adpters.outbound.repositories

import com.challencg.product_api.adpters.outbound.entities.ProductEntity
import com.challencg.product_api.adpters.outbound.entities.toDomain
import com.challencg.product_api.domain.product.CategoriaRepository
import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.Product
import com.challencg.product_api.domain.product.ProductRepository
import org.springframework.stereotype.Repository

@Repository
class ProductRepositoryImpl(
    private val jpaProductRepository: JpaProductRepository,
    private val jpaCategoriaRepository: CategoriaRepository,
) : ProductRepository {
    override fun save(product: Product): Product {
        val productToSave = ProductEntity(
            id = null,
            name = product.name,
            category = product.category?.id
        )

        val newProduct = jpaProductRepository.save(productToSave)

        val categoryEntity = product.category?.id?.let {
            jpaCategoriaRepository.findById(it).orElse(null)
        }

        val category = categoryEntity?.let {
            Category(
                id = it.id,
                name = it.name,
                categoriaPai = it.categoriaPai?.toDomain()
            )
        }

        return Product(
            id = newProduct.id,
            name = newProduct.name,
            category = category
        )
    }

    override fun findById(id: Long): Product? {
        val productEntity = jpaProductRepository.findById(id).orElse(null) ?: return null

        val categoryEntity = productEntity.category?.let {
            jpaCategoriaRepository.findById(it).orElse(null)
        }

        val category = categoryEntity?.let {
            Category(
                id = it.id,
                name = it.name,
                categoriaPai = it.categoriaPai?.toDomain()
            )
        }

        return Product(
            id = productEntity.id!!,
            name = productEntity.name,
            category = category
        )
    }

    override fun findAll(): List<Product> {
        return jpaProductRepository.findAll().map { entity ->

            val categoryEntity = entity.category?.let {
                jpaCategoriaRepository.findById(it).orElse(null)
            }

            val category = categoryEntity?.let {
                Category(
                    id = it.id,
                    name = it.name,
                    categoriaPai = it.toDomain()
                )
            }

            Product(
                id = entity.id!!,
                name = entity.name,
                category = category
            )
        }
    }
}
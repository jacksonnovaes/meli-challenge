package com.challencg.product_api.adpters.outbound.repositories

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import com.challencg.product_api.domain.product.CategoriaRepository
import com.challencg.product_api.domain.product.Category
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
class CategoryRepositoryImpl(
    private val categoryRepository: JpaCategoryRepository
) : CategoriaRepository {
    override fun save(category: Category): Category {
        val categorySaved = CategoryEntity(
            id = null,
            name = category.name,
            categorias = emptySet()
        )

        val newCategory = categoryRepository.save(categorySaved)
        return Category(
            newCategory.id!!,
            newCategory.name
        )
    }

    override fun findById(id: UUID): Optional<Category> {
        return categoryRepository.findById(id).map { it
            Category(
                it.id!!,
                it.name
            )
        }
    }

    override fun findAll(): List<Category> {
       return categoryRepository.findAll().map { it ->
           Category(
               it.id!!,
               it.name
           )
       }
    }

}
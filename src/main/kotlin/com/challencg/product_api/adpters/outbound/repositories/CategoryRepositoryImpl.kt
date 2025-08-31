package com.challencg.product_api.adpters.outbound.repositories

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import com.challencg.product_api.domain.product.CategoriaRepository
import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.toEntity
import org.springframework.stereotype.Repository
import java.util.Optional
import java.util.UUID

@Repository
class CategoryRepositoryImpl(
    private val categoryRepository: JpaCategoryRepository
) : CategoriaRepository {

    override fun save(category: Category): CategoryEntity {


        val categorySaved = CategoryEntity(
            id = category.id,
            name = category.name,
            categoriaPai = category.categoriaPai?.toEntity()
        )

        val newCategory = categoryRepository.save(categorySaved)
        return newCategory
    }

    override fun findById(id: Long): Optional<CategoryEntity> {
        return categoryRepository.findById(id)

    }

    override fun findAll(): List<CategoryEntity> {
       return categoryRepository.findAll().map { it ->
           CategoryEntity(
               it.id!!,
               it.name
           )
       }
    }

}
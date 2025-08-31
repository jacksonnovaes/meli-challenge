package com.challencg.product_api.application.usecases.impl

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import com.challencg.product_api.adpters.outbound.entities.toDomain
import com.challencg.product_api.application.usecases.CategoryUseCases
import com.challencg.product_api.application.usecases.ProductUseCases
import com.challencg.product_api.domain.product.CategoriaRepository
import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.Product
import com.challencg.product_api.domain.product.ProductRepository
import com.challencg.product_api.infrastructure.exceptions.EntityNotFoundException
import org.springframework.stereotype.Service
import java.util.*

@Service
class CategoryUseCaseImpl(
    private val categoriaRepository: CategoriaRepository
): CategoryUseCases {
    override fun save(category: Category): Category {
       val categorySaved =  categoriaRepository.save(category)
          return categorySaved.toDomain()
    }

    override fun detailCategory(id: Long): Optional<Category> {
        val categoryFinded =  categoriaRepository.findById(id).orElseThrow {
            EntityNotFoundException("nao encontrado")
        }
        return Optional.of(categoryFinded.toDomain())
    }

    override fun detailCategoryPai(category: Category): Optional<CategoryEntity> {
        TODO("Not yet implemented")
    }
}
package com.challencg.product_api.domain.product

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import java.util.*

interface CategoriaRepository {

    fun save(category: Category): CategoryEntity

    fun findById(id: Long): Optional<CategoryEntity>

    fun findAll(): List<CategoryEntity>
}
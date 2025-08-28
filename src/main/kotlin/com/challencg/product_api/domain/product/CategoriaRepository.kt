package com.challencg.product_api.domain.product

import java.util.*

interface CategoriaRepository {

    fun save(category: Category): Category

    fun findById(id: UUID): Optional<Category>

    fun findAll(): List<Category>
}
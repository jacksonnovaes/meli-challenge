package com.challencg.product_api.application.usecases

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import com.challencg.product_api.domain.product.Category
import java.util.Optional

interface CategoryUseCases {

    fun save(category: Category): Category

    fun detailCategory(id: Long): Optional<Category>

    fun detailCategoryPai(category: Category): Optional<CategoryEntity>
}
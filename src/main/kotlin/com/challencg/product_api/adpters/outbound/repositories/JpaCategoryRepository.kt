package com.challencg.product_api.adpters.outbound.repositories

import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface JpaCategoryRepository: JpaRepository<CategoryEntity, UUID> {

}
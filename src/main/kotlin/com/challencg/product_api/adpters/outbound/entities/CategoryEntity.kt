package com.challencg.product_api.adpters.outbound.entities

import com.challencg.product_api.domain.product.Category
import jakarta.persistence.*

@Table(name="tb_category")
@Entity
data class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String = "",
    @ManyToOne
    @JoinColumn(name = "parent_id")
    val categoriaPai: CategoryEntity? = null
)

fun CategoryEntity.toDomain(): Category =
    Category(
        id = this.id,
        name = this.name,
        categoriaPai = this.categoriaPai?.toDomain()
    )
package com.challencg.product_api.adpters.outbound.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.util.UUID

@Table(name="tb_product")
@Entity
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID?,
    val name: String,
    val category: Long?
)
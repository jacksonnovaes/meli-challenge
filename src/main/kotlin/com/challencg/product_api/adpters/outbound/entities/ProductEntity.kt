package com.challencg.product_api.adpters.outbound.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import java.math.BigDecimal

@Table(name="tb_product")
@Entity
data class ProductEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,
    val name: String = "",
    val descricao: String = "",
    val rate: Float = 0.0F,
    val price: BigDecimal,
    val category: Long? = null
)
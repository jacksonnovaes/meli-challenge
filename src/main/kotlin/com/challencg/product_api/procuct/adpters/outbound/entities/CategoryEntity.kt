package com.challencg.product_api.procuct.adpters.outbound.entities

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.JoinTable
import jakarta.persistence.ManyToMany
import jakarta.persistence.Table
import java.util.UUID

@Table(name="tb_category")
@Entity
data class CategoryEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    val id: UUID,
    val name: String,
    @ManyToMany
    @JoinTable  (
    name = "tb_produto_categoria",
    joinColumns = [JoinColumn(name = "produto_id")],
    inverseJoinColumns = [JoinColumn(name = "categoria_id")]
)
val categorias: Set<CategoryEntity> = mutableSetOf()
)
package com.challencg.product_api.adpters.inbound.controller

import com.challencg.product_api.adpters.inbound.dto.request.CategoryRequestDTO
import com.challencg.product_api.adpters.inbound.dto.response.CategoryResponseDTO
import com.challencg.product_api.adpters.outbound.entities.CategoryEntity
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import java.util.Optional


interface CategoryController {

    @PostMapping
    fun save(category: CategoryRequestDTO): ResponseEntity<CategoryResponseDTO>
    @GetMapping("/{id}")
    fun detailProduct(id: Long): ResponseEntity<Optional<CategoryResponseDTO>>
    @PostMapping("/{id}")
    fun saveCategoriaPai(id: Long, categoryIds: Long): ResponseEntity<CategoryResponseDTO>
}
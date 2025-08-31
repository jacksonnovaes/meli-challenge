package com.challencg.product_api.adpters.inbound.controller.impl

import com.challencg.product_api.adpters.inbound.controller.CategoryController
import com.challencg.product_api.adpters.inbound.dto.request.CategoryRequestDTO
import com.challencg.product_api.adpters.inbound.dto.request.toDomain
import com.challencg.product_api.adpters.inbound.dto.response.CategoryResponseDTO
import com.challencg.product_api.application.usecases.CategoryUseCases
import com.challencg.product_api.domain.product.Category
import com.challencg.product_api.domain.product.toResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/category")

class CategoryControllerImpl(
    private val categoryUseCases: CategoryUseCases
): CategoryController {

    @PostMapping
    override fun save(@RequestBody category: CategoryRequestDTO): ResponseEntity<CategoryResponseDTO> {

      val categorySaved = categoryUseCases.save(category.toDomain())

        return ResponseEntity.ok(categorySaved.toResponseDTO())
    }
    @GetMapping("/{id}")
    override fun detailProduct(@PathVariable id: Long): ResponseEntity<Optional<CategoryResponseDTO>> {
       return ResponseEntity.ok(Optional.of(categoryUseCases.detailCategory(id).get().toResponseDTO()))
    }



    @PostMapping("/{id}")
    override fun saveCategoriaPai(@PathVariable id: Long, @RequestBody categoryId: Long): ResponseEntity<CategoryResponseDTO> {
        val categoryFound = categoryUseCases.detailCategory(id)
            .orElseThrow { RuntimeException("Categoria $id não encontrada") }

        val categoriasPai =
            categoryUseCases.detailCategory(categoryId)
                .orElseThrow { RuntimeException("Categoria pai $categoryId não encontrada")}

        val updatedCategory = Category(
            id = categoryFound.id,
            name = categoryFound.name,
            categoriaPai = categoriasPai
        )

        val savedCategory = categoryUseCases.save(updatedCategory)

        return ResponseEntity.ok(savedCategory.toResponseDTO())
    }
}
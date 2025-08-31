package com.challencg.product_api.adpters.inbound.controller.impl

import com.challencg.product_api.adpters.inbound.controller.ProductController
import com.challencg.product_api.adpters.inbound.dto.request.ProductRequestDTO
import com.challencg.product_api.adpters.inbound.dto.request.toDomain
import com.challencg.product_api.adpters.inbound.dto.response.ProductResponseDTO
import com.challencg.product_api.application.usecases.CategoryUseCases
import com.challencg.product_api.application.usecases.ProductUseCases
import com.challencg.product_api.domain.product.toResponseDTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/product")

class ProductControllerImpl(
    private val productUseCases : ProductUseCases,
    private val categoryUseCases: CategoryUseCases
): ProductController {
    @PostMapping
    override fun save(@RequestBody productDTO: ProductRequestDTO): ResponseEntity<ProductResponseDTO> {

        val procuctSaved = productUseCases.save(productDTO.toDomain())


        return ResponseEntity.ok(procuctSaved.toResponseDTO())
    }
    @GetMapping("/{id}")
    override fun detailProduct(@PathVariable id: Long): ResponseEntity<ProductResponseDTO> {
        val product = productUseCases.detailProduct(id)
            ?: return ResponseEntity.notFound().build()
        return ResponseEntity.ok(product.toResponseDTO())
    }
}
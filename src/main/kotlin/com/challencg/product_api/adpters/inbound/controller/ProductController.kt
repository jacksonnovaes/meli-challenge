package com.challencg.product_api.adpters.inbound.controller

import com.challencg.product_api.adpters.inbound.dto.request.ProductRequestDTO
import com.challencg.product_api.adpters.inbound.dto.response.ProductResponseDTO
import org.springframework.http.ResponseEntity


interface ProductController {
    fun save(productDTO: ProductRequestDTO): ResponseEntity<ProductResponseDTO>

    fun detailProduct(id: Long): ResponseEntity<ProductResponseDTO>
}
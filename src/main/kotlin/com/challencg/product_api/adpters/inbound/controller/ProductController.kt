package com.challencg.product_api.adpters.inbound.controller

import com.challencg.product_api.adpters.inbound.dto.ProductDTO
import com.challencg.product_api.domain.product.Product
import org.springframework.http.ResponseEntity


interface ProductController {
    fun save(productDTO: ProductDTO): ResponseEntity<ProductDTO>

    fun detailProduct(id: Long): ResponseEntity<Product>
}
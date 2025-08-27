package com.challencg.product_api.procuct.adpters.inbound.controller

import com.challencg.product_api.procuct.domain.product.Product
import org.springframework.http.ResponseEntity


interface ProductController {
    fun save(): ResponseEntity<Product>

    fun detailProduct(id: Long): ResponseEntity<Product>
}
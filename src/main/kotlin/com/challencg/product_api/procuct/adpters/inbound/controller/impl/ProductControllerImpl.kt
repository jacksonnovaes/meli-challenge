package com.challencg.product_api.procuct.adpters.inbound.controller.impl

import com.challencg.product_api.procuct.adpters.inbound.controller.ProductController
import com.challencg.product_api.procuct.domain.product.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RestController

@RestController(value = "/api/product")
class ProductControllerImpl (

): ProductController {
    override fun save(): ResponseEntity<Product> {
        TODO("Not yet implemented")
    }

    override fun detailProduct(id: Long): ResponseEntity<Product> {
        TODO("Not yet implemented")
    }
}
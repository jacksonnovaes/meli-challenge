package com.challencg.product_api.adpters.inbound.controller.impl

import com.challencg.product_api.adpters.inbound.controller.ProductController
import com.challencg.product_api.adpters.inbound.dto.ProductDTO
import com.challencg.product_api.application.usecases.ProductUseCases
import com.challencg.product_api.domain.product.Product
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/product")

class ProductControllerImpl(
    private val productUseCases : ProductUseCases
): ProductController {
    @PostMapping
    override fun save(@RequestBody productDTO: ProductDTO): ResponseEntity<ProductDTO> {
      val product = Product(
          id = null,
          name = productDTO.name,
          categoryId = productDTO.categoryId
      )
      val procuctSaved = productUseCases.save(product)

        return ResponseEntity.ok(ProductDTO(
            procuctSaved.name,
            procuctSaved.categoryId
        ))
    }
    @GetMapping
    override fun detailProduct(id: Long): ResponseEntity<Product> {
        TODO("Not yet implemented")
    }
}
package com.challencg.product_api.infrastructure.config;

import com.challencg.product_api.infrastructure.exceptions.EntityNotFoundException;
import com.challencg.product_api.infrastructure.exceptions.StandardError
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
class ControllerExceptionHandler {

    @ExceptionHandler(EntityNotFoundException::class)
    fun notFound404(ex: EntityNotFoundException, req: HttpServletRequest): ResponseEntity<StandardError> {
        val err = StandardError(
            HttpStatus.NOT_FOUND.value(),
            ex.message,
            System.currentTimeMillis(),
            req.requestURI
        )
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err)
    }
}

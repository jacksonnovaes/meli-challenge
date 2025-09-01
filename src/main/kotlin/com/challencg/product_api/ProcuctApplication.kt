package com.challencg.product_api

import com.challencg.product_api.adpters.inbound.dto.request.CategoryRequestDTO
import com.challencg.product_api.adpters.inbound.dto.request.toDomain
import com.challencg.product_api.application.usecases.CategoryUseCases
import com.challencg.product_api.domain.product.Category
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ProcuctApplication(
    private val categoryUseCases: CategoryUseCases
) : CommandLineRunner {


    override fun run(vararg args: String?) {
       val eletronicos = CategoryRequestDTO(
           name = "eletronicos"
       )
        val informatica = CategoryRequestDTO(
            name = "informatica"
        )
        val notebooks = CategoryRequestDTO(
            name = "notebooks"
        )
        val savedEletronicos = categoryUseCases.save(eletronicos.toDomain())
       val savedInformatica =  categoryUseCases.save(informatica.toDomain())
        val savedNotebooksa =  categoryUseCases.save(notebooks.toDomain())

        val updatedCategoryEletronico = Category(
            id = savedEletronicos.id,
            name = savedEletronicos.name,
            categoriaPai = savedInformatica
        )
        val updatedCategoryInformatica = Category(
            id = savedInformatica.id,
            name = savedInformatica.name,
            categoriaPai = savedNotebooksa  
        )
        categoryUseCases.save(updatedCategoryEletronico)
        categoryUseCases.save(updatedCategoryInformatica)
    }


}
fun main(args: Array<String>) {
    runApplication<ProcuctApplication>(*args)
}
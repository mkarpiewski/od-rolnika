package uk.co.objectivity.odchlopa.service

import org.springframework.stereotype.Component
import uk.co.objectivity.odchlopa.entities.ProductEntity
import uk.co.objectivity.odchlopa.repositories.ProductRepository

@Component
class Service (var productRepository: ProductRepository){

    fun getProduct(): ProductEntity? {
        return productRepository.findAll().firstOrNull()
    }
}

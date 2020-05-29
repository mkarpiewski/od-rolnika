package uk.co.objectivity.odchlopa.repositories

import org.springframework.data.repository.CrudRepository
import uk.co.objectivity.odchlopa.entities.BasketEntity


interface BasketRepository: CrudRepository<BasketEntity, Long> {
    fun findByBuyerId(id: Long): BasketEntity
}

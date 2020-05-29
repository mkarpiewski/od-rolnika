package uk.co.objectivity.odchlopa.repositories

import org.springframework.data.repository.CrudRepository
import uk.co.objectivity.odchlopa.entities.Basket


interface BasketRepository: CrudRepository<Basket, Long>

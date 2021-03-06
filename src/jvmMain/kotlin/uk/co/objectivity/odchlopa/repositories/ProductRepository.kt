package uk.co.objectivity.odchlopa.repositories

import org.springframework.data.repository.CrudRepository
import uk.co.objectivity.odchlopa.entities.ProductEntity

interface ProductRepository : CrudRepository<ProductEntity, Long>

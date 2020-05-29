package uk.co.objectivity.odchlopa.repositories

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import uk.co.objectivity.odchlopa.entities.Seller

interface SellerRepository : JpaRepository<Seller, Long>
package uk.co.objectivity.odchlopa.service

import org.springframework.stereotype.Component
import uk.co.objectivity.odchlopa.entities.Seller
import uk.co.objectivity.odchlopa.repositories.SellerRepository
import java.util.*

@Component
class SellerService (var sellerRepository: SellerRepository) {

    fun getSellers() : Iterable<Seller> {
        return sellerRepository.findAll()
    }

    fun addSeller(name: String) : Seller {
        return sellerRepository.save(Seller(name))
    }

    fun getSeller(id: Long): Seller? {
        return sellerRepository.findById(id).orElse(null)
    }
}

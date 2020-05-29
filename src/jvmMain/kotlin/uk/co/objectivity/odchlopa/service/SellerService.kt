package uk.co.objectivity.odchlopa.service

import org.springframework.stereotype.Component
import uk.co.objectivity.odchlopa.entities.Seller
import uk.co.objectivity.odchlopa.repositories.SellerRepository

@Component
class SellerService (var sellerRepository: SellerRepository) {

    fun getSellers() : Iterable<Seller> {
        return sellerRepository.findAll()
    }
}

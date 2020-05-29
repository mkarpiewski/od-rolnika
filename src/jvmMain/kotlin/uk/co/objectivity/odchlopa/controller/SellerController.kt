package uk.co.objectivity.odchlopa.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.objectivity.odchlopa.entities.Seller
import uk.co.objectivity.odchlopa.service.SellerService

@RestController
class SellerController (var sellerService: SellerService) {

    @GetMapping("/seller")
    fun getSellers() : Iterable<Seller> {
        return sellerService.getSellers()
    }
}

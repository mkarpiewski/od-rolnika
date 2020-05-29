package uk.co.objectivity.odchlopa.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uk.co.objectivity.odchlopa.controller.model.SellerModel
import uk.co.objectivity.odchlopa.entities.Seller
import uk.co.objectivity.odchlopa.service.SellerService

@RestController
class SellerController (var sellerService: SellerService) {

    @GetMapping("/sellers")
    fun getSellers() : Iterable<Seller> {
        return sellerService.getSellers()
    }

    @PostMapping("/sellers")
    fun addSeller(@RequestBody request: SellerModel) : ResponseEntity<Long> {
        return ResponseEntity(sellerService.addSeller(request.name))
    }
}

package uk.co.objectivity.odchlopa.controller

import org.apache.coyote.Response
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import uk.co.objectivity.odchlopa.controller.model.SellerModel
import uk.co.objectivity.odchlopa.controller.model.SellerReadModel
import uk.co.objectivity.odchlopa.entities.Seller
import uk.co.objectivity.odchlopa.service.SellerService
import java.net.URI
import java.util.*
import javax.transaction.Transactional

@RestController
class SellerController(var sellerService: SellerService) {

    @GetMapping("/sellers")
    fun getSellers(): Iterable<Seller> {
        return sellerService.getSellers()
    }

    @GetMapping("/sellers/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    @Transactional()
    fun getSeller(@PathVariable("id") id: Long) : ResponseEntity<SellerReadModel> {
        var seller = sellerService.getSeller(id)

        return Optional.ofNullable(seller).map { SellerReadModel(it.id, it.name) }
                .map { ResponseEntity.ok(it as SellerReadModel) }
                .orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/sellers")
    fun addSeller(@RequestBody request: SellerModel): ResponseEntity<SellerReadModel> {
        var seller = sellerService.addSeller(request.name);

        return ResponseEntity
                .created(URI.create("/sellers/" + seller.id))
                .body(seller.id?.let { SellerReadModel(it, seller.name) });
    }
}

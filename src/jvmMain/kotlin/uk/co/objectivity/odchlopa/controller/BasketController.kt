package uk.co.objectivity.odchlopa.controller

import common.Basket
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.objectivity.odchlopa.entities.BasketEntity
import uk.co.objectivity.odchlopa.entities.ProductEntity
import uk.co.objectivity.odchlopa.service.BasketService

@RestController
@RequestMapping("/baskets")
class BasketController(var basketService: BasketService) {

    @GetMapping
    fun getBasketForBuyer(buyerId: Long): Basket {
        return basketService.getBasketForBuyer(buyerId)
    }

    @PostMapping
    fun addBasket(buyerId: Long) {
        basketService.createBasket(buyerId)
    }

    @PostMapping("/test")
    fun addBasketTest() {
        val basket = BasketEntity(buyerId = 1, products = mutableListOf())
        val product = ProductEntity(name = "cebula", price = 1, baskets = mutableListOf(basket))
        basket.products.add(product)

        basketService.addBasket(basket)
    }
}

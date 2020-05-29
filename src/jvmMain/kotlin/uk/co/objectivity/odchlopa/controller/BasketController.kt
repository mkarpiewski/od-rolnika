package uk.co.objectivity.odchlopa.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.objectivity.odchlopa.entities.Basket
import uk.co.objectivity.odchlopa.entities.Product
import uk.co.objectivity.odchlopa.service.BasketService

@RestController
@RequestMapping("/baskets")
class BasketController(var basketService: BasketService) {

    @GetMapping
    fun getBasket(): Basket? {
        return basketService.getBasket()
    }

    @PostMapping
    fun addBasket() {
        val basket = Basket(buyerId = 1, products = mutableListOf())
        val product = Product(name = "cebula", price = 1, baskets = mutableListOf(basket))
        basket.products.add(product)

        basketService.addBasket(basket)
    }
}

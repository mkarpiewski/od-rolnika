package uk.co.objectivity.odchlopa.controller

import common.Basket
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.objectivity.odchlopa.entities.BasketEntity
import uk.co.objectivity.odchlopa.entities.BasketItemEntity
import uk.co.objectivity.odchlopa.service.BasketService

@RestController
@RequestMapping("/baskets")
class BasketController(var basketService: BasketService) {

    @GetMapping
    fun getBasketForBuyer(buyerId: Long): Basket {
        return basketService.getBasketForBuyer(buyerId)
    }

    @PostMapping
    fun createBasket(buyerId: Long) {
        basketService.createBasket(buyerId)
    }

    @PostMapping("/test")
    fun addBasketTest() {
        val basket = BasketEntity(buyerId = 1,
                items = mutableListOf(BasketItemEntity(productId = 1, quantity = 2, price = 12), BasketItemEntity(productId = 2, quantity = 3, price = 13)))

        basketService.addBasket(basket)
    }

    @PostMapping("/product")
    fun addProductToBasked(buyerId: Long, productId: Long, price: Number): Basket {
        basketService.update(buyerId, productId, price)

        return basketService.getBasketForBuyer(buyerId)
    }
}

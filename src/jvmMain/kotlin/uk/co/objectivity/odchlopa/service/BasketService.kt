package uk.co.objectivity.odchlopa.service

import common.Basket
import common.Product
import org.springframework.stereotype.Service
import uk.co.objectivity.odchlopa.entities.BasketEntity
import uk.co.objectivity.odchlopa.mapper.toBasket
import uk.co.objectivity.odchlopa.repositories.BasketRepository

@Service
class BasketService(var basketRepository: BasketRepository) {

    fun getBasketForBuyer(buyerId: Long) = basketRepository.findByBuyerId(buyerId).toBasket()

    fun createBasket(buyerId: Long) {
        basketRepository.save(BasketEntity(buyerId = buyerId, products = mutableListOf()))
    }

    fun addBasket(basketEntity: BasketEntity) = basketRepository.save(basketEntity)
}

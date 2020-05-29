package uk.co.objectivity.odchlopa.service

import org.springframework.stereotype.Service
import uk.co.objectivity.odchlopa.entities.BasketEntity
import uk.co.objectivity.odchlopa.entities.BasketItemEntity
import uk.co.objectivity.odchlopa.mapper.toBasket
import uk.co.objectivity.odchlopa.repositories.BasketRepository

@Service
class BasketService(var basketRepository: BasketRepository) {

    fun getBasketForBuyer(buyerId: Long) = basketRepository.findByBuyerId(buyerId).toBasket()

    fun createBasket(buyerId: Long) {
        basketRepository.save(BasketEntity(buyerId = buyerId, items = mutableListOf()))
    }

    fun addBasket(basketEntity: BasketEntity) = basketRepository.save(basketEntity)

    fun update(buyerId: Long, productId: Long, price: Number) {
        val basketEntity = basketRepository.findByBuyerId(buyerId)

        val item: BasketItemEntity? = basketEntity.items.find { it.productId == productId }

        if (item != null) {
            item.quantity++
            item.price = item.price.toDouble() + price.toDouble()
        } else {
            basketEntity.items.add(BasketItemEntity(productId = productId, quantity = 1, price = price))
        }

        basketRepository.save(basketEntity)
    }
}

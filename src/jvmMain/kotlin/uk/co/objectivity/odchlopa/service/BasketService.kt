package uk.co.objectivity.odchlopa.service

import common.Basket
import common.Product
import org.springframework.stereotype.Service
import uk.co.objectivity.odchlopa.entities.BasketEntity
import uk.co.objectivity.odchlopa.entities.ProductEntity
import uk.co.objectivity.odchlopa.mapper.toBasket
import uk.co.objectivity.odchlopa.repositories.BasketRepository
import uk.co.objectivity.odchlopa.repositories.ProductRepository

@Service
class BasketService(var basketRepository: BasketRepository, var productRepository: ProductRepository) {

    fun getBasketForBuyer(buyerId: Long) = basketRepository.findByBuyerId(buyerId).toBasket()

    fun createBasket(buyerId: Long) {
        basketRepository.save(BasketEntity(buyerId = buyerId, products = mutableListOf()))
    }

    fun addBasket(basketEntity: BasketEntity) = basketRepository.save(basketEntity)

    fun updateBasket(basket: Basket) {
        val basketEntity = basketRepository.findByBuyerId(basket.buyerId)
        val products = basket.products.map { productRepository.findById(it.id!!).get() }
        basketRepository.save(BasketEntity(basketEntity.id, basket.buyerId, products.toMutableList()))
    }
}

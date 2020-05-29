package uk.co.objectivity.odchlopa.service

import org.springframework.stereotype.Service
import uk.co.objectivity.odchlopa.entities.Basket
import uk.co.objectivity.odchlopa.repositories.BasketRepository

@Service
class BasketService(var basketRepository: BasketRepository) {

    fun getBasket() = basketRepository.findAll().firstOrNull()

    fun addBasket(basket: Basket) = basketRepository.save(basket)
}

package uk.co.objectivity.odchlopa.mapper

import common.Basket
import common.Product
import uk.co.objectivity.odchlopa.entities.BasketEntity

fun BasketEntity.toBasket() = Basket(
        buyerId,
        this.products.sumByDouble { it.price.toDouble() },
        this.products.map { Product(it.name, it.price) }.toMutableList()
)

package uk.co.objectivity.odchlopa.mapper

import common.Basket
import common.BasketItem
import uk.co.objectivity.odchlopa.entities.BasketEntity

fun BasketEntity.toBasket() = Basket(
        buyerId,
        this.items.sumByDouble { it.price.toDouble() },
        this.items.map { BasketItem(it.productId, it.quantity, it.price) }.toMutableList()
)

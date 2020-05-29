package common

data class Basket (
        var buyerId: Long,
        var price: Number,
        var items: MutableList<BasketItem>
)

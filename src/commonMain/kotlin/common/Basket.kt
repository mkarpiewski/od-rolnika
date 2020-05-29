package common

data class Basket (
        var buyerId: Long,
        var price: Number,
        var products: MutableList<Product>
)

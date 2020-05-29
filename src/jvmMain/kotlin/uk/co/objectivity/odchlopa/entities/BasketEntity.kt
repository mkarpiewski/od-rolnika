package uk.co.objectivity.odchlopa.entities

import javax.persistence.*

@Entity
@Table(name = "basket")
class BasketEntity(
        @Id @GeneratedValue var id: Long? = null,
        var buyerId: Long,
        @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
        var items: MutableList<BasketItemEntity>
)

@Entity
@Table(name = "basket_item")
class BasketItemEntity(
        @Id @GeneratedValue var id: Long? = null,
        var productId: Long,
        var quantity: Int,
        var price: Number
)

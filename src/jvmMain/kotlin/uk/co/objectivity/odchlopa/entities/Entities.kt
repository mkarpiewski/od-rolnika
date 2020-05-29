package uk.co.objectivity.odchlopa.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.ManyToMany

@Entity
class Product(
        var name: String,
        var price: Number,
        @ManyToMany var baskets: MutableList<Basket>? = null,
        @Id @GeneratedValue var id: Long? = null
)

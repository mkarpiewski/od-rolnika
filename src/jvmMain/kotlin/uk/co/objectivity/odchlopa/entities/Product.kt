package uk.co.objectivity.odchlopa.entities

import javax.persistence.*

@Entity
class Product(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY) var id: Long? = null,
        var name: String,
        var price: Number,
        @ManyToOne
    var seller: Seller
)

package uk.co.objectivity.odchlopa.entities

import javax.persistence.*

@Entity
@Table(name = "product")
class ProductEntity(
        var name: String,
        var price: Number,
        @Id @GeneratedValue var id: Long? = null
)

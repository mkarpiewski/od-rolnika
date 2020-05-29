package uk.co.objectivity.odchlopa.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Seller(
        @Id @GeneratedValue var id: Long? = null,
        var name: String,

        var city: String,
        var street: String,
        var homeNumber: String,
        var postCode: String,

        var aboutMe: String
)

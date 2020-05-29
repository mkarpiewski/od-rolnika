package uk.co.objectivity.odchlopa.entities

import javax.persistence.*

@Entity
class Seller(
        var name: String
) {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
    var city: String? = null
    var street: String? = null
    var homeNumber: String? = null
    var postCode: String? = null
    var aboutMe: String? = null

    @OneToMany(cascade = [(CascadeType.ALL)], fetch = FetchType.EAGER, mappedBy = "seller")
    var products: MutableList<Product> = ArrayList()
}

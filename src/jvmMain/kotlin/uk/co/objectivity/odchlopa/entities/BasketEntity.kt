package uk.co.objectivity.odchlopa.entities

import javax.persistence.*

@Entity
@Table(name = "basket")
class BasketEntity(
        @Id @GeneratedValue var id: Long? = null,
        var buyerId: Long,
        @ManyToMany(mappedBy = "baskets", fetch = FetchType.EAGER, cascade = [CascadeType.PERSIST])
        var products: MutableList<ProductEntity>
)

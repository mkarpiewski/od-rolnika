package seller

import react.*
import react.dom.*

external interface SellerListProps: RProps {
    var sellers: Array<Seller>
}

class SellerList: RComponent<SellerListProps, RState>() {
    override fun RBuilder.render() {
        for (seller in props.sellers) {
            div {
                key = seller.id.toString()
                h2 {
                    +"${seller.name} (id: ${seller.id})"
                }
                p {
                    b { +"Trochę o mnie: " }
                    span { +"${seller.aboutMe}" }
                }
                p { +"Adres: ${seller.city} ${seller.street} ${seller.homeNumber} ${seller.postCode}" }
                hr {}
            }
        }
    }
}

fun RBuilder.sellerList(handler: SellerListProps.() -> Unit): ReactElement {
    return child(SellerList::class) {
        this.attrs(handler)
    }
}
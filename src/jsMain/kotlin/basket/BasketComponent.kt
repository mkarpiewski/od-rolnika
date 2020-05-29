package basket

import react.RBuilder
import react.RComponent
import react.RProps
import react.RState

class BasketComponent: RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        child(ProductList::class) {
            attrs.products = listOf("Cebula", "Ziemniaki")
        }
    }
}
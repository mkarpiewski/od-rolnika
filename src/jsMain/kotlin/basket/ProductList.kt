package basket

import react.RBuilder
import react.RComponent
import react.RState
import react.dom.p

class ProductList : RComponent<BasketProps, RState>() {
    override fun RBuilder.render() {
        for (product in props.products) {
            p {
                +"Product: $product"
            }
        }
    }
}
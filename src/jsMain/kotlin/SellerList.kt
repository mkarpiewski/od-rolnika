import react.*
import react.dom.*


external interface SellerListProps: RProps {
    var sellers: Array<Seller>
}

class SellerList: RComponent<SellerListProps, RState>() {
    override fun RBuilder.render() {
        console.log("Sellers List: ");
        console.log(props.sellers);
        for (seller in props.sellers) {
            p {
                key = seller.id.toString()
                +"${seller.id}: ${seller.name}"
            }
        }
    }
}

fun RBuilder.sellerList(handler: SellerListProps.() -> Unit): ReactElement {
    return child(SellerList::class) {
        this.attrs(handler)
    }
}
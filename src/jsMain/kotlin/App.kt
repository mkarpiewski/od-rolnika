import basket.BasketComponent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        browserRouter {
            child(TopBar::class) {}
            switch {
                route("/", OverView::class, exact = true)
                route("/seller", SellerComponent::class)
                route("/basket", BasketComponent::class)
            }
        }
    }
}
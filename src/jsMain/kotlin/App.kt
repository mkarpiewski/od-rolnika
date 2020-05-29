import basket.BasketComponent
import react.RBuilder
import react.RComponent
import react.RProps
import react.RState
import react.router.dom.browserRouter
import react.router.dom.route
import react.router.dom.switch

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        sellers = arrayOf<Seller>()

        val mainScope = MainScope()
        mainScope.launch {
            val newSellers = fetchSellers()

            setState {
                sellers = newSellers
            }
        }
    }

    override fun RBuilder.render() {
        browserRouter {
            child(TopBar::class) {}
            switch {
                route("/", OverView::class, exact = true)
                route("/basket", BasketComponent::class)
            }
        }
    }
}
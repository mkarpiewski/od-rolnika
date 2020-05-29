import react.*
import react.dom.*
import kotlin.browser.window
import kotlinx.coroutines.*

data class Seller(
        val id: Long?,
        val name: String,
        val city: String,
        val street: String,
        val homeNumber: String,
        val postCode: String,
        val aboutMe: String
)

suspend fun fetchSellers(): Array<Seller> =
        window.fetch("http://localhost:8080/sellers")
                .await()
                .json()
                .await()
                .unsafeCast<Array<Seller>>()

external interface AppState: RState {
    var sellers: Array<Seller>
}

class SellerComponent: RComponent<RProps, AppState>() {

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
        h1 {
            +"Lista sprzedawców"
        }
        sellerList {
            sellers = state.sellers
        }
    }
}
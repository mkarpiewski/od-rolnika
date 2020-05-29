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

//suspend fun fetchSeller(id: Int): Seller =
//        window.fetch("https://my-json-server.typicode.com/kotlin-hands-on/kotlinconf-json/sellers/$id")
//                .await()
//                .json()
//                .await()
//                .unsafeCast<Seller>()
//
//suspend fun fetchSellers(): List<Seller> = coroutineScope {
//    (1..25).map { id ->
//        async {
//            fetchSeller(id)
//        }
//    }.awaitAll()
//}

suspend fun fetchSellers(): Array<Seller> =
        window.fetch("http://localhost:8080/seller")
                .await()
                .json()
                .await()
                .unsafeCast<Array<Seller>>()

external interface AppState: RState {
    var sellers: Array<Seller>
}

class App : RComponent<RProps, AppState>() {

    override fun AppState.init() {
        sellers = arrayOf<Seller>(Seller(1, "name 2","name","name","name","name","name"))

        val mainScope = MainScope()
        mainScope.launch {
            val newSellers = fetchSellers()
            console.log(newSellers)
            //val newSellers = listOf<Seller>(Seller(2, "name 34344","name","name","name","name","name"))

            setState {
                sellers = newSellers
            }
        }
    }

    override fun RBuilder.render() {
        p {
            +"From react"
        }
        h1 {
            +"Nowy paragraf 26"
        }
        sellerList {
            sellers = state.sellers
        }
    }
}
package uk.co.objectivity.odchlopa

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import uk.co.objectivity.odchlopa.entities.Seller

@SpringBootApplication
class OdChlopaApplication

fun main(args: Array<String>) {
    runApplication<OdChlopaApplication>(*args)
    var seller: Seller = Seller("someseller")
    println(seller.aboutMe)
    println(seller.products)
}

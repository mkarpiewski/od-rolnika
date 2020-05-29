package uk.co.objectivity.odchlopa.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import uk.co.objectivity.odchlopa.service.Service

@RestController("/")
class ResourcesController(var service: Service) {
    @GetMapping("test")
    fun getAny(): String {
        return "Test"
    }
}

package io.github.makbn.traefiksdk.controller

import io.swagger.annotations.ApiOperation
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController("/ping")
class Ping{
    @GetMapping("")
    @ApiOperation(value = "A simple endpoint to check for Traefik process liveness. Return a code 200 with the content: OK", httpMethod = "GET")
    fun ping():  ResponseEntity<Any>? {

        return null
    }
}
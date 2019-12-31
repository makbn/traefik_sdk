package io.github.makbn.traefiksdk.controller

import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController("/v2/debug")
class DebugController @Autowired constructor(
        private val restTemplate : RestTemplate
){




    @GetMapping("/vars")
    @ApiOperation(value = "See the https://golang.org/pkg/expvar/ Go documentation.", httpMethod = "GET")
    fun vars(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/pprof/")
    @ApiOperation(value = "See the https://golang.org/pkg/net/http/pprof/#Index Go documentation.", httpMethod = "GET")
    fun pprofs(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/pprof/cmdline")
    @ApiOperation(value = "See the https://golang.org/pkg/net/http/pprof/#Cmdline Go documentation.", httpMethod = "GET")
    fun cmdline(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/pprof/profile")
    @ApiOperation(value = "See the https://golang.org/pkg/net/http/pprof/#Profile Go documentation.", httpMethod = "GET")
    fun profile(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/pprof/symbol")
    @ApiOperation(value = "See the pprof https://golang.org/pkg/net/http/pprof/#Symbol Go documentation.", httpMethod = "GET")
    fun symbol(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/pprof/trace")
    @ApiOperation(value = "See the https://golang.org/pkg/net/http/pprof/#Trace Go documentation.", httpMethod = "GET")
    fun trace(): ResponseEntity<Any>? {

        return null
    }
}
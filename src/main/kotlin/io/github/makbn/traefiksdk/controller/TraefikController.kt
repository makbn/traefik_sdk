package io.github.makbn.traefiksdk.controller

import io.github.makbn.traefiksdk.model.Middleware
import io.github.makbn.traefiksdk.model.Result
import io.github.makbn.traefiksdk.model.Router
import io.github.makbn.traefiksdk.model.Service
import io.github.makbn.traefiksdk.service.TraefikService
import io.github.makbn.traefiksdk.util.ResFact
import io.swagger.annotations.ApiOperation
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate


@RestController
@RequestMapping("/v2")
class TraefikController @Autowired constructor(
        private val restTemplate: RestTemplate,
        private var traefikService: TraefikService,
        @Value("\${traefik.host}")
        private val TRAEFIK_HOST: String,
        @Value("\${traefik.port}")
        private val TRAEFIK_PORT: Int

) {

    @GetMapping("/api/http/routers")
    @ApiOperation(value = "Lists all the HTTP routers information.", httpMethod = "GET")
    fun getHttpRouts(): ResponseEntity<Result<Array<Router>>> {

        var routers = restTemplate.getForObject("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/routers",
                Array<Router>::class.java)

        return ResponseEntity.ok(ResFact.build<Array<Router>>()
                .setResult(routers!!)
                .get())
    }

    @GetMapping("/api/http/routers/{name}")
    @ApiOperation(value = "Returns the information of the HTTP router specified by name.", httpMethod = "GET")
    fun getHttpRoutByName(@PathVariable("name") name: String): ResponseEntity<Result<Router>> {

        var router = restTemplate.getForObject("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/routers/$name",
                Router::class.java)

        return ResponseEntity.ok(ResFact.build<Router>()
                .setResult(router!!)
                .get())
    }


    @GetMapping("/api/http/services")
    @ApiOperation(value = "\tLists all the HTTP services information.", httpMethod = "GET")
    fun getServices(): ResponseEntity<Result<Array<Service>>> {

        var services = restTemplate.getForObject("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/services",
                Array<Service>::class.java)


        var p = traefikService.proxyNativeApi<Array<Service>>("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/services", Array<Service>::class.java)

       /* return ResponseEntity.ok(ResFact.build<Array<Service>>()
                .setResult(services!!)
                .get())*/
        return ResponseEntity.ok(p)
    }


    @GetMapping("/api/http/services/{name}")
    @ApiOperation(value = "Returns the information of the HTTP service specified by name.", httpMethod = "GET")
    fun getServicesByName(@PathVariable("name") name: String): ResponseEntity<Result<Service>> {

        var service = restTemplate.getForObject("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/service/$name",
                Service::class.java)

        return ResponseEntity.ok(ResFact.build<Service>()
                .setResult(service!!)
                .get())
    }


    @GetMapping("/api/http/middlewares")
    @ApiOperation(value = "Lists all the HTTP middlewares information.", httpMethod = "GET")
    fun getMiddlewares(): ResponseEntity<Result<Array<Middleware>>> {

        var middlewares = restTemplate.getForObject("$TRAEFIK_HOST:$TRAEFIK_PORT/api/http/middlewares",
                Array<Middleware>::class.java)

        return ResponseEntity.ok(ResFact.build<Array<Middleware>>()
                .setResult(middlewares!!)
                .get())
    }

    @GetMapping("/api/http/middlewares/{name}")
    @ApiOperation(value = "Returns the information of the HTTP middleware specified by name.", httpMethod = "GET")
    fun getMiddlewares(@PathVariable("name") name: String): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/tcp/routers")
    @ApiOperation(value = "Lists all the TCP routers information.", httpMethod = "GET")
    fun getTCPRouts(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/tcp/routers/{name}")
    @ApiOperation(value = "Returns the information of the TCP router specified by name.", httpMethod = "GET")
    fun getTCPRouts(@PathVariable("name") name: String): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/tcp/services")
    @ApiOperation(value = "Lists all the TCP services information.", httpMethod = "GET")
    fun getTCPServices(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/tcp/services/{name}")
    @ApiOperation(value = "Returns the information of the TCP service specified by name.", httpMethod = "GET")
    fun getTCPServiceByName(@PathVariable("name") name: String): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/entrypoints")
    @ApiOperation(value = "Lists all the entry points information.", httpMethod = "GET")
    fun getEntrypoints(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/entrypoints/{name}")
    @ApiOperation(value = "Returns the information of the entry point specified by name.", httpMethod = "GET")
    fun getEntrypointByName(@PathVariable("name") name: String): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/overview")
    @ApiOperation(value = "Returns statistic information about http and tcp as well as enabled features and providers.", httpMethod = "GET")
    fun getOverview2(): ResponseEntity<Any>? {

        return null
    }

    @GetMapping("/api/version")
    @ApiOperation(value = "Returns information about Traefik version.", httpMethod = "GET")
    fun getOverview3(): ResponseEntity<Any>? {

        return null
    }

}
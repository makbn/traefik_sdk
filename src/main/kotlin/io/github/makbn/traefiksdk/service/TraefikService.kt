package io.github.makbn.traefiksdk.service
import io.github.makbn.traefiksdk.model.Middleware
import io.github.makbn.traefiksdk.model.Result
import io.github.makbn.traefiksdk.util.ResFact
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Lazy
import org.springframework.stereotype.Component
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import kotlin.reflect.KClass

@Service
class TraefikService @Autowired constructor(val restTemplate: RestTemplate){

    fun<T> proxyNativeApi(path : String, returnType : Class<T>) : Result<T> {

        var data = restTemplate.getForObject(path, returnType)

        return ResFact.build<T>().setResult(data!!).get()
    }
}
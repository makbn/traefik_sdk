package io.github.makbn.traefiksdk.util

import io.github.makbn.traefiksdk.model.Result
import org.springframework.http.HttpStatus

class ResFact<T> private constructor(private val restResponse: Result<T>)
{

    fun setResult(result: T): ResFact<T> {
        this.restResponse.result = result
        return this
    }

    fun setError(hasError: Boolean): ResFact<T> {
        this.restResponse.isError = hasError
        return this
    }

    fun setMessage(message: String): ResFact<T> {
        this.restResponse.message = message
        return this
    }

    fun setCode(status: HttpStatus): ResFact<T> {
        this.restResponse.code = status.value()
        return this
    }

    fun get(): Result<T> {
        return restResponse
    }

    companion object {
        fun <T> build(): ResFact<T> {
            return ResFact(Result<T>())
        }
    }
}

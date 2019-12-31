package io.github.makbn.traefiksdk.model

import java.net.HttpURLConnection

data class Result<T>  @JvmOverloads constructor(var code: Int = HttpURLConnection.HTTP_OK,
                                                var message :String = "Ok.",
                                                var result: T? = null,
                                                var isError: Boolean = false)




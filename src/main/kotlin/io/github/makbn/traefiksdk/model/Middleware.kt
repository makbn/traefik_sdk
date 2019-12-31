package io.github.makbn.traefiksdk.model

import java.io.Serializable

data class Middleware @JvmOverloads constructor(var userdBy : ArrayList<String> = ArrayList()) : Serializable {

    lateinit var name: String
    lateinit var provider: String
    lateinit var redirectRegex: RedirectRegex

}
package io.github.makbn.traefiksdk.model

import java.io.Serializable


data class RedirectRegex @JvmOverloads constructor(var permanent : Boolean = true) : Serializable {

    lateinit var regex : String
    lateinit var replacement: String

}
package io.github.makbn.traefiksdk.model

import java.io.Serializable


data class Service @JvmOverloads constructor(var usedBy: ArrayList<String> = ArrayList()) : Serializable{
    lateinit var name : String
    lateinit var provider : String
    lateinit var status : String
}


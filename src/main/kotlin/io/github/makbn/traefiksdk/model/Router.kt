package io.github.makbn.traefiksdk.model

import java.io.Serializable
import java.util.*
import kotlin.collections.ArrayList


data class Router @JvmOverloads constructor(var  entryPoints : ArrayList<String> = ArrayList(),
                                            var using : ArrayList<String> = ArrayList()) : Serializable {
    lateinit var name : String
    lateinit var rule : String
    lateinit var provider : String
    lateinit var service : String
    lateinit var status : String
    var priority : Long = 0

    constructor(name: String, provider : String,  entryPoints : ArrayList<String>, service : String, status : String,
                using : ArrayList<String>, priority : Long = 0) : this() {
        this.name = name
        this.priority = priority
        this.provider = provider
        this.entryPoints = entryPoints
        this.rule = rule
        this.service = service
        this.status = status
        this.using = using
    }

    override fun toString(): String {
        return "Router(entryPoints=${entryPoints}, " +
                "service='$service', " +
                "priority=$priority, " +
                "status='$status', " +
                "using=${using}, " +
                "name='$name', provider='$provider')"
    }

}
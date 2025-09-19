package me.hd.wauxv.zygisk.hook.util

import kotlinx.serialization.json.Json

object WJson {
    private val json = Json {
        ignoreUnknownKeys = true
        encodeDefaults = true
        isLenient = true
        prettyPrint = false
    }

    internal inline fun <reified T> encodeToString(value: T): String {
        return json.encodeToString(value)
    }

    internal inline fun <reified T> decodeFromString(jsonString: String): T {
        return json.decodeFromString(jsonString)
    }
}

package me.hd.wauxv.zygisk.hook.apps.wx.data

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable
import me.hd.wauxv.zygisk.hook.util.WJson
import java.io.File

object ConfigData {
    @Serializable
    data class Config(
        val version: String = HostData.toVerStr(),
        val antiRevoke: String = "Lbi0/s;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V",
    )

    lateinit var config: Config

    @SuppressLint("SdCardPath")
    fun init() {
        if (::config.isInitialized.not()) {
            val configFile = File("/data/user/0/com.tencent.mm/shared_prefs/wauxv_config.json")
            config = if (configFile.exists()) {
                WJson.decodeFromString<Config>(configFile.readText())
            } else {
                val defaultConfig = Config()
                configFile.writeText(WJson.encodeToString(defaultConfig))
                defaultConfig
            }
        }
    }
}

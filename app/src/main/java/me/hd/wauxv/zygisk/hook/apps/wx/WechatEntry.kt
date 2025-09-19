package me.hd.wauxv.zygisk.hook.apps.wx

import me.hd.wauxv.zygisk.hook.apps.wx.data.ConfigData
import me.hd.wauxv.zygisk.hook.apps.wx.data.HostData
import me.hd.wauxv.zygisk.hook.apps.wx.hooker.AntiRevokeHooker
import me.hd.wauxv.zygisk.hook.util.WLog

object WechatEntry {
    lateinit var configData: ConfigData

    fun init(loader: ClassLoader) {
        HostData.init(loader)
        WLog.info("running on: ${HostData.toVerStr()}")
        if (::configData.isInitialized.not()) {
            configData = ConfigData()
        }
        listOf(
            AntiRevokeHooker,
        ).forEach { hooker ->
            hooker.load()
        }
    }
}

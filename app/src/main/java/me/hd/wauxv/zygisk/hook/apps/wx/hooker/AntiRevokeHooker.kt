package me.hd.wauxv.zygisk.hook.apps.wx.hooker

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.v7878.r8.annotations.DoNotObfuscate
import com.v7878.r8.annotations.DoNotShrink
import com.v7878.vmtools.Hooks
import com.v7878.vmtools.Hooks.EntryPointType
import me.hd.wauxv.zygisk.hook.apps.wx.base.BaseHooker
import me.hd.wauxv.zygisk.hook.apps.wx.data.ConfigData
import me.hd.wauxv.zygisk.hook.apps.wx.data.HostData.toDexMethod

object AntiRevokeHooker : BaseHooker() {
    override val name = "阻止消息撤回"

    @Suppress("unused")
    @JvmStatic
    @DoNotShrink
    @DoNotObfuscate
    private fun doRevokeMsg() {
    }

    override fun initOnce() {
        val target = ConfigData.config.antiRevoke.toDexMethod()
        val hooker = AntiRevokeHooker::class.resolve().firstMethod { name = "doRevokeMsg" }
        Hooks.hook(target, hooker.self, EntryPointType.DIRECT)
    }
}

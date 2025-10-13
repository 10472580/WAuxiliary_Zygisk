package me.hd.wauxv.zygisk.hook.apps.wx.data

import com.highcapable.kavaref.KavaRef.Companion.resolve
import com.highcapable.kavaref.extension.toClass
import org.luckypray.dexkit.wrap.DexClass
import org.luckypray.dexkit.wrap.DexMethod
import kotlin.properties.Delegates

object HostData {
    var appClassLoader by Delegates.notNull<ClassLoader>()
    var verName by Delegates.notNull<String>()
    var verCode by Delegates.notNull<Int>()
    var verClient by Delegates.notNull<String>()
    var isPlay by Delegates.notNull<Boolean>()

    fun String.toAppClass() = toClass(appClassLoader)
    fun String.toDexClass() = DexClass(this).getInstance(appClassLoader)
    fun String.toDexMethod() = DexMethod(this).getMethodInstance(appClassLoader)
    fun String.toDexConstructor() = DexMethod(this).getConstructorInstance(appClassLoader)

    fun init(loader: ClassLoader) {
        appClassLoader = loader
        "com.tencent.mm.boot.BuildConfig".toAppClass().resolve().apply {
            verName = firstField { name = "VERSION_NAME" }.get<String>()!!
            verCode = firstField { name = "VERSION_CODE" }.get<Int>()!!
            verClient = firstField { name = "CLIENT_VERSION_ARM64" }.get<String>()!!
            isPlay = firstField { name = "BUILD_TAG" }.get<String>()!!.contains("_GP_")
        }
    }

    fun toVerStr(): String {
        return buildString {
            if (isPlay) append("Play")
            append(verName)
            append("($verCode)")
            append("_")
            append(verClient)
        }
    }
}

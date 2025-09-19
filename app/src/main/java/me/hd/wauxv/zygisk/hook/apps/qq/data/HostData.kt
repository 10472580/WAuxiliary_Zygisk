package me.hd.wauxv.zygisk.hook.apps.qq.data

import com.highcapable.kavaref.extension.toClass
import kotlin.properties.Delegates

object HostData {
    var appClassLoader by Delegates.notNull<ClassLoader>()

    fun String.toAppClass() = toClass(appClassLoader)

    fun init(loader: ClassLoader) {
        appClassLoader = loader
    }

    fun toVerStr() = ""
}

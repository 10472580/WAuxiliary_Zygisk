package me.hd.wauxv.zygisk.hook.apps.wx.data

import android.annotation.SuppressLint
import kotlinx.serialization.Serializable
import me.hd.wauxv.zygisk.hook.util.WJson
import java.io.File

object ConfigData {
    @Serializable
    data class Config(
        val version: String = HostData.toVerStr(),
        val antiRevoke: String = when {
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_62) -> "Llt0/s;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_61) -> "Lzs0/s;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_60) -> "Lvr0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_58) -> "Lgr0/s;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_57) -> "Lyp0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_56) -> "Ldp0/t;->l(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_54) -> "Lio0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_51) -> "Ltn0/t;->l(Ljava/lang/String;JLcom/tencent/mm/modelbase/o0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_49) -> "Lwk0/t;->i(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_48) -> "Lrj0/s;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeastPlay(VerData.PlayVersion.V8_0_41) -> "Lyf0/g;->r(Ljava/lang/String;JLjg0/m\$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V\n"
            VerData.isAtLeast(VerData.Version.V8_0_63) -> "Ljt0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_62) -> "Lfs0/s;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_61) -> "Lpr0/s;->m(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_60) -> "Lwq0/s;->l(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_58) -> "Lfq0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_57) -> "Loo0/t;->l(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_56) -> "Lvn0/t;->m(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_55) -> "Lnm0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_54) -> "Lan0/s;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/p0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_53) -> "Lzm0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/o0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_51) -> "Ltm0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/o0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_50) -> "Lik0/t;->k(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_49) -> "Ltj0/s;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_48) -> "Lij0/s;->i(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_47) -> "Lri0/t;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_46) -> "Lri0/t;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_45) -> "Lbi0/s;->h(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_44) -> "Lsh0/s;->n(Ljava/lang/String;JLcom/tencent/mm/modelbase/n0;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_43) -> "Lof0/g;->q(Ljava/lang/String;JLzf0/m\$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_42) -> "Lnf0/g;->q(Ljava/lang/String;JLyf0/m\$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_41) -> "Lkd0/g;->q(Ljava/lang/String;JLvd0/m\$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            VerData.isAtLeast(VerData.Version.V8_0_40) -> "Lwc0/g;->z(Ljava/lang/String;JLhd0/m\$a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V"
            else -> ""
        },
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

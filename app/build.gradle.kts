plugins {
    id("build-logic.android.application")
    alias(libs.plugins.java.zygisk)
    alias(libs.plugins.lsparanoid)
    alias(libs.plugins.serialization)
}

zygisk {
    packages("com.tencent.mm", "com.tencent.mobileqq", "com.tencent.tim")

    id = "me_hd_wauxv_zygisk"
    name = "WAuxv Zygisk"
    author = "HdShare"
    description = "WAuxv-Zygisk-v${GitVersion.getBuildVersionName(rootProject)}"
    entrypoint = "me.hd.wauxv.zygisk.Main"
    archiveName = "WAuxv-Zygisk-v${GitVersion.getBuildVersionName(rootProject)}"
    isAttachNativeLibs = false
}

lsparanoid {
    includeDependencies = false
    variantFilter = { variant ->
        if (variant.buildType == "release") {
            seed = android.defaultConfig.versionCode
            classFilter = { it.startsWith("me.hd.wauxv.") }
            true
        } else {
            false
        }
    }
}

android {
    namespace = "me.hd.wauxv.zygisk"
    ndkVersion = BuildVersion.NDK_VERSION

    defaultConfig {
        ndk.abiFilters.addAll(arrayOf("arm64-v8a"))
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll(
            "-Xno-call-assertions",
            "-Xno-param-assertions",
            "-Xno-receiver-assertions"
        )
    }
}

dependencies {
    implementation(libs.r8.annotations)
    implementation(libs.androidvmtools)
    implementation(libs.kavaref.core)
    implementation(libs.kavaref.extension)
    implementation(libs.dexkit)
    implementation(libs.serialization.json)
}

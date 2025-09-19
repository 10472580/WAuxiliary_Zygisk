@file:Suppress("UnstableApiUsage")

import com.android.build.gradle.BaseExtension

plugins {
    id("com.android.base")
    kotlin("android")
}

extensions.findByType(BaseExtension::class)?.run {
    compileSdkVersion(BuildVersion.COMPILE_SDK)
    ndkVersion = BuildVersion.NDK_VERSION

    defaultConfig {
        minSdk = BuildVersion.MIN_SDK
        targetSdk = BuildVersion.TARGET_SDK
        versionCode = GitVersion.getBuildVersionCode(rootProject)
        versionName = GitVersion.getBuildVersionName(rootProject)
    }

    compileOptions {
        sourceCompatibility = BuildVersion.java
        targetCompatibility = BuildVersion.java
    }
}

kotlin {
    jvmToolchain(BuildVersion.jvmToolchain)
}

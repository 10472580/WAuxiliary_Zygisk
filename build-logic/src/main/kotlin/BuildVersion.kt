import org.gradle.api.JavaVersion

object BuildVersion {
    val java = JavaVersion.VERSION_17
    val jvmToolchain = java.toString().toInt()

    const val MIN_SDK = 27
    const val TARGET_SDK = 36
    const val COMPILE_SDK = 36

    const val CMAKE_VERSION = "3.22.1"
    const val NDK_VERSION = "28.0.13004108"

    const val VERSION_NAME = "1.0.0"
}

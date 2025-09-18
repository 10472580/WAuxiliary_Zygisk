import org.gradle.api.JavaVersion

object BuildVersion {
    val java = JavaVersion.VERSION_17
    val jvmToolchain = java.toString().toInt()

    const val minSdk = 27
    const val targetSdk = 36
    const val compileSdk = 36

    const val cmakeVersion = "3.22.1"
    const val ndkVersion = "28.0.13004108"

    const val versionName = "1.0.0"
}

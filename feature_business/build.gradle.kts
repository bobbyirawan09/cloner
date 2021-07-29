import BuildModules.CORE
import BuildModules.UTILS
import extensions.*

plugins {
    id(Plugins.COMMON_ANDROID_LIBRARY)
    id("kotlin-android")
}
dependencies {
    implementation(project(CORE))
    implementation(project(UTILS))
    implementation("org.jetbrains.kotlin:kotlin-stdlib:${rootProject.extra["kotlin_version"]}")
    implementation("androidx.legacy:legacy-support-v4:1.0.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.3.1")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.1")

//    addRoomDependencies()
    addCoroutineDependencies()
    addFeatureDependencies()
    addGlideDependencies()
    addKoinCoreUIDependencies()
    addPagingDependencies()
}

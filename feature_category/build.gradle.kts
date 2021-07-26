import BuildModules.CORE
import BuildModules.UTILS
import extensions.*

plugins {
    id(Plugins.COMMON_ANDROID_LIBRARY)
}
dependencies {
    implementation(project(CORE))
    implementation(project(UTILS))

    addRoomDependencies()
    addCoroutineDependencies()
    addFeatureDependencies()
    addGlideDependencies()
    addKoinCoreUIDependencies()
}

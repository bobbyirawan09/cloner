import BuildModules.CORE
import BuildModules.UTILS
import extensions.addCoroutineDependencies
import extensions.addKoinCoreUIDependencies
import extensions.addFeatureDependencies
import extensions.addGlideDependencies

plugins {
    id(Plugins.COMMON_ANDROID_LIBRARY)
}
dependencies {
    implementation(project(CORE))
    implementation(project(UTILS))

    addCoroutineDependencies()
    addFeatureDependencies()
    addGlideDependencies()
    addKoinCoreUIDependencies()
}

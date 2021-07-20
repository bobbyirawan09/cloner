import BuildModules.CORE
import extensions.addCoroutineDependencies
import extensions.addKoinCoreUIDependencies
import extensions.addFeatureDependencies
import extensions.addGlideDependencies

plugins {
    id(Plugins.COMMON_ANDROID_LIBRARY)
}
dependencies {
    implementation(project(CORE))

    addCoroutineDependencies()
    addFeatureDependencies()
    addGlideDependencies()
    addKoinCoreUIDependencies()
}

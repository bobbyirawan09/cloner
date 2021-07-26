import BuildModules.CORE
import BuildModules.UTILS
import extensions.*
import org.gradle.kotlin.dsl.kapt
import dependencies.Dependencies

plugins {
    id(Plugins.COMMON_ANDROID_LIBRARY)
}
dependencies {
    implementation(project(CORE))
    implementation(project(UTILS))
    kapt(Dependencies.ROOM_KAPT)

    addCoroutineDependencies()
    addFeatureDependencies()
    addGlideDependencies()
    addKoinCoreUIDependencies()
}

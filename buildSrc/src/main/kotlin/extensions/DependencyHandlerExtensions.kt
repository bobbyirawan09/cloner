package extensions

import dependencies.Dependencies
import dependencies.TestAndroidDependencies
import dependencies.TestDependencies
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler

/**
 * Adds a dependency to the `debugImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.debugImplementation(dependencyNotation: String): Dependency? =
    add("debugImplementation", dependencyNotation)

/**
 * Adds a dependency to the `implementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.implementation(dependencyNotation: String): Dependency? =
    add("implementation", dependencyNotation)

/**
 * Adds a dependency to the `api` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.api(dependencyNotation: String): Dependency? =
    add("api", dependencyNotation)

/**
 * Adds a dependency to the `kapt` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.kapt(dependencyNotation: String): Dependency? =
    add("kapt", dependencyNotation)

/**
 * Adds a dependency to the `testImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.testImplementation(dependencyNotation: String): Dependency? =
    add("testImplementation", dependencyNotation)


/**
 * Adds a dependency to the `androidTestImplementation` configuration.
 *
 * @param dependencyNotation name of dependency to add at specific configuration
 *
 * @return the dependency
 */
fun DependencyHandler.androidTestImplementation(dependencyNotation: String): Dependency? =
    add("androidTestImplementation", dependencyNotation)

/**
 * Adds all the tests dependencies to android specific configuration.
 */
fun DependencyHandler.addTestsDependencies() {
    testImplementation(TestDependencies.JUNIT)

    androidTestImplementation(TestAndroidDependencies.EXT)
    androidTestImplementation(TestAndroidDependencies.ESPRESSO)
}

/**
 * Adds all the tests dependencies to kotlin specific configuration.
 */
fun DependencyHandler.addKotlinTestsDependencies() {
    testImplementation(TestDependencies.JUNIT)
}

fun DependencyHandler.addNetworkDependencies() {
    api(Dependencies.RETROFIT)
    implementation(Dependencies.RETROFIT_GSON_CONVERTER)
    implementation(Dependencies.OKHTTP)
}

fun DependencyHandler.addCoroutineDependencies() {
    implementation(Dependencies.COROUTINES_CORE)
    implementation(Dependencies.COROUTINES_ANDROID)
}

fun DependencyHandler.addKoinCoreDependencies() {
    implementation(Dependencies.KOIN_ANDROID)
    implementation(Dependencies.KOIN_CORE)
}

fun DependencyHandler.addKoinCoreUIDependencies() {
    addKoinCoreDependencies()
    implementation(Dependencies.KOIN_ANDROID_VIEW_MODEL)
}

fun DependencyHandler.addFeatureDependencies() {
    implementation(Dependencies.CORE_KTX)
    implementation(Dependencies.APPCOMPAT)
    implementation(Dependencies.LEGACY_SUPPORT)
    implementation(Dependencies.LIVE_DATA)
    implementation(Dependencies.VIEW_MODEL)
}

fun DependencyHandler.addGlideDependencies() {
    implementation(Dependencies.GLIDE)
    kapt(Dependencies.GLIDE_COMPILER)
}

fun DependencyHandler.addRoomDependencies() {
    implementation(Dependencies.ROOM)
    implementation(Dependencies.ROOM_KTX)
    kapt(Dependencies.ROOM_KAPT)
}

fun DependencyHandler.addPagingDependencies() {
    implementation(Dependencies.PAGING)
}

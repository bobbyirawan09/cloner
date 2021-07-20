package dependencies
/**
 * All the Project dependencies are declared here.
 * These can be used across the Project
 */

object DependencyVersions {
    const val APPCOMPAT = "1.3.0"
    const val CONSTRAINT_LAYOUT = "2.0.4"
    const val CORE_KTX = "1.3.2"
    const val KOTLIN = "1.4.30"
    const val KTLINT = "0.40.0"
    const val MATERIAL = "1.2.1"
    const val LEGACY_SUPPORT = "1.0.0"

    // Tests
    const val EXT = "1.1.2"
    const val ESPRESSO = "3.3.0"
    const val JUNIT = "4.13.1"

    //Retrofit
    const val RETROFIT = "2.9.0"
    const val OKHTTP = "4.9.0"

    //Coroutine
    const val COROUTINE = "1.3.9"

    //Koin
    const val KOIN = "2.1.6"

    //Lifecycle
    const val LIFECYCLE = "2.3.1"

    //Glide
    const val GLIDE = "4.12.0"

    //Gson
    const val GSON = "2.8.7"
}

object Dependencies {
    const val APPCOMPAT = "androidx.appcompat:appcompat:${DependencyVersions.APPCOMPAT}"
    const val CONSTRAINT_LAYOUT = "androidx.constraintlayout:constraintlayout:${DependencyVersions.CONSTRAINT_LAYOUT}"
    const val CORE_KTX = "androidx.core:core-ktx:${DependencyVersions.CORE_KTX}"
    const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib:${DependencyVersions.KOTLIN}"
    const val MATERIAL = "com.google.android.material:material:${DependencyVersions.MATERIAL}"
    const val LEGACY_SUPPORT = "androidx.legacy:legacy-support-v4:${DependencyVersions.LEGACY_SUPPORT}"

    //Retrofit
    const val RETROFIT = "com.squareup.retrofit2:retrofit:${DependencyVersions.RETROFIT}"
    const val RETROFIT_GSON_CONVERTER = "com.squareup.retrofit2:converter-gson:${DependencyVersions.RETROFIT}"
    const val OKHTTP = "com.squareup.okhttp3:logging-interceptor:${DependencyVersions.OKHTTP}"

    //COROUTINES
    const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${DependencyVersions.COROUTINE}"
    const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${DependencyVersions.COROUTINE}"

    //KOIN
    const val KOIN_CORE = "org.koin:koin-core:${DependencyVersions.KOIN}"
    const val KOIN_ANDROID = "org.koin:koin-android:${DependencyVersions.KOIN}"
    const val KOIN_ANDROID_VIEW_MODEL = "org.koin:koin-android-viewmodel:${DependencyVersions.KOIN}"

    //Lifecycle
    const val LIVE_DATA = "androidx.lifecycle:lifecycle-livedata-ktx:${DependencyVersions.LIFECYCLE}"
    const val VIEW_MODEL = "androidx.lifecycle:lifecycle-viewmodel-ktx:${DependencyVersions.LIFECYCLE}"

    //Glide
    const val GLIDE_COMPILER = "com.github.bumptech.glide:compiler:${DependencyVersions.GLIDE}"
    const val GLIDE = "com.github.bumptech.glide:glide:${DependencyVersions.GLIDE}"

    //Gson
    const val GSON = "com.google.code.gson:gson:${DependencyVersions.GSON}"
}

package dependencies

/**
 * All the Project Test dependencies are declared here.
 * These can be used across the Project
 */
object TestAndroidDependencies {
    const val ESPRESSO = "androidx.test.espresso:espresso-core:${DependencyVersions.ESPRESSO}"
    const val EXT = "androidx.test.ext:junit:${DependencyVersions.EXT}"
}

object TestDependencies {
    const val JUNIT = "junit:junit:${DependencyVersions.JUNIT}"
}

/*
 * Copyright 2021 Vishal Choudhary
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package commons

import AndroidConfig
import BuildProductDimensions
import BuildType
import BuildTypeDebug
import BuildTypeRelease
import ProductFlavorDevelop
import ProductFlavorProduction
import dependencies.Dependencies
import extensions.addTestsDependencies
import extensions.getLocalProperty
import extensions.implementation

plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(AndroidConfig.COMPILE_SDK_VERSION)

    defaultConfig {
        minSdkVersion(AndroidConfig.MIN_SDK_VERSION)
        targetSdkVersion(AndroidConfig.TARGET_SDK_VERSION)

        versionCode = AndroidConfig.VERSION_CODE
        versionName = AndroidConfig.VERSION_NAME

        testInstrumentationRunner = AndroidConfig.TEST_INSTRUMENTATION_RUNNER
        consumerProguardFile("consumer-rules.pro")
    }

    buildFeatures {
        viewBinding = AndroidConfig.VIEW_BINDING_ENABLED
    }

    buildTypes {
        getByName(BuildType.RELEASE) {
            proguardFiles("proguard-android-optimize.txt", "proguard-rules.pro")

            isMinifyEnabled = BuildTypeRelease.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeRelease.isTestCoverageEnabled

            manifestPlaceholders["MAPS_API_KEY"] = getLocalProperty("MAPS_API_KEY")

            buildConfigField("String", "YELP_BASE_URL", "\"https://api.yelp.com/v3/\"")
            buildConfigField("String", "YELP_API_KEY", getLocalProperty("YELP_API_KEY"))
            buildConfigField(
                "String",
                "SKY_SCANNER_BASE_URL",
                "\"https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/\""
            )
            buildConfigField(
                "String",
                "SKY_SCANNER_API_KEY",
                getLocalProperty("SKY_SCANNER_API_KEY")
            )
            buildConfigField(
                "String",
                "SKY_SCANNER_API_HOST",
                getLocalProperty("SKY_SCANNER_API_HOST")
            )
        }
        getByName(BuildType.DEBUG) {
            isMinifyEnabled = BuildTypeDebug.isMinifyEnabled
            isTestCoverageEnabled = BuildTypeDebug.isTestCoverageEnabled

            manifestPlaceholders["MAPS_API_KEY"] = getLocalProperty("MAPS_API_KEY")

            buildConfigField("String", "YELP_BASE_URL", "\"https://api.yelp.com/v3/\"")
            buildConfigField("String", "YELP_API_KEY", getLocalProperty("YELP_API_KEY"))
            buildConfigField(
                "String",
                "SKY_SCANNER_BASE_URL",
                "\"https://skyscanner-skyscanner-flight-search-v1.p.rapidapi.com/apiservices/autosuggest/v1.0/\""
            )
            buildConfigField(
                "String",
                "SKY_SCANNER_API_KEY",
                getLocalProperty("SKY_SCANNER_API_KEY")
            )
            buildConfigField(
                "String",
                "SKY_SCANNER_API_HOST",
                getLocalProperty("SKY_SCANNER_API_HOST")
            )
        }
    }

    flavorDimensions(BuildProductDimensions.ENVIRONMENT)
    productFlavors {
        ProductFlavorDevelop.libraryCreate(this)
        ProductFlavorProduction.libraryCreate(this)
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = JavaVersion.VERSION_1_8.toString()
    }

    sourceSets {
        getByName("main") {
            java.srcDir("src/main/kotlin")
        }
        getByName("test") {
            java.srcDir("src/test/kotlin")
        }
        getByName("androidTest") {
            java.srcDir("src/androidTest/kotlin")
        }
    }

    lintOptions {
        lintConfig = rootProject.file(".lint/config.xml")
        isCheckAllWarnings = true
        isWarningsAsErrors = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
        unitTests.isReturnDefaultValues = true
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(Dependencies.KOTLIN)

    addTestsDependencies()
}

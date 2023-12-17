import org.gradle.internal.impldep.org.bouncycastle.asn1.crmf.SinglePubInfo.web
import org.jetbrains.kotlin.gradle.targets.js.ir.DefaultIncrementalSyncTask
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpack

plugins {
    kotlin("multiplatform") version "1.9.21"
    id("org.jetbrains.compose") version "1.6.0-alpha01"
    id("com.google.devtools.ksp") version "1.9.21-1.0.15"
    application
}

group = "nu.saler"
version = "1.0"

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

kotlin{
    js {
        moduleName = "koin-compose-canvas-js"
        binaries.executable()
        browser {
            commonWebpackConfig {
                cssSupport {
                    enabled.set(true)
                }
                outputFileName = "koin-compose-canvas.js"
            }
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(compose.runtime)
                implementation(compose.ui)
                implementation(compose.foundation)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.material3)
                implementation(compose.materialIconsExtended)
                @OptIn(org.jetbrains.compose.ExperimentalComposeLibrary::class)
                implementation(compose.components.resources)
            }
        }
        val jsMain by getting{
            dependencies {
                kotlin.srcDir("build/generated/ksp/js/jsMain/kotlin")
                api("io.insert-koin:koin-core:3.4.3")
                api("io.insert-koin:koin-test:3.4.3")
                api("io.insert-koin:koin-annotations:1.3.0")
            }
        }
    }
}

dependencies {
    add("kspJs", "io.insert-koin:koin-ksp-compiler:1.3.0")
}

ksp{
    arg("KOIN_CONFIG_CHECK","true")
    arg("KOIN_DEFAULT_MODULE","false")
}

compose{
    experimental{
        web.application
    }
}

project.tasks.whenTaskAdded {
    if (name == "compileCommonMainKotlinMetadata") {
        enabled = false
    }
}

configurations.all {
    resolutionStrategy.eachDependency {
        if (requested.module.name.startsWith("kotlin-stdlib")) {
            useVersion("1.9.21")
        }
        // kotlinx-datetime-wasm-js:0.4.1-wasm0 depends on outdated kotlinx-serialization-core:1.5.2-wasm0
        if (requested.module.name.contains("kotlinx-serialization") && requested.version == "1.5.2-wasm0") {
            useVersion("1.6.1-wasm0")
        }
    }
}
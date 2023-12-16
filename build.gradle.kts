plugins {
    kotlin("jvm") version "1.9.21"
    id()
}

group = "nu.saler"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}
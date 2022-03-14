import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20-M1" apply false

    id("nebula.release") version "16.0.0"
}

allprojects {
    group = "com.iamceph.stargate"
    version = "1.0.0-SNAPSHOT"

    tasks.withType<JavaCompile> {
        sourceCompatibility = "1.8"
        targetCompatibility = "1.8"
    }

    tasks.withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }
}

subprojects {
    apply {
        plugin("idea")
        plugin("java-library")
        plugin("maven-publish")
    }

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
package com.iamceph.stargate.common.extension

import com.iamceph.stargate.common.dependency.StargateDependency
import com.iamceph.stargate.common.dependency.ext.starDependency
import org.gradle.api.Project
import org.gradle.api.tasks.Input
import org.gradle.kotlin.dsl.property
import javax.inject.Inject

open class StargateVersionsExtension
@Inject constructor(
    @Input val name: String,
    val project: Project
) {

    val springBoot = project.objects.property<String>().apply {
        set(resolveSpringVersion() ?: "2.6.4")
    }

    fun SPRING_BOOT(name: String): StargateDependency {
        return starDependency {
            this.group = "org.springframework.boot"
            this.name = name
            this.version = springBoot.get()
        }
    }

    fun SPRING_STARTER(name: String): StargateDependency {
        return SPRING_BOOT("spring-boot-starter-$name")
    }

    private fun resolveSpringVersion(): String? =
        runCatching {
            val bootPlugin = Class.forName("org.springframework.boot.gradle.plugin.SpringBootPlugin")
            val coordinatesField = bootPlugin
                .fields
                .firstOrNull { it.name == "BOM_COORDINATES" }
                ?: return null

            val version = coordinatesField.get(null)
                ?: throw UnsupportedOperationException("Version not found.")

            version as String
        }.getOrNull()
}
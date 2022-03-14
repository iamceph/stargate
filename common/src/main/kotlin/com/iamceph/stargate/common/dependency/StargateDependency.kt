package com.iamceph.stargate.common.dependency

import org.gradle.api.GradleException
import java.util.function.Function

interface StargateDependency {
    val group: String
    val name: String
    val version: String?

    fun hasVersion(): Boolean = version != null

    fun versionModifier(): Function<String, String> {
        return Function { it }
    }

    fun format(customVersion: String? = null): String {
        val realVersion = customVersion ?: version
        ?: throw GradleException("Cannot find version for $group:$name!")

        return "$group:$name:${versionModifier().apply(realVersion)}"
    }

    companion object {
        fun of(group: String, name: String, version: String? = null): StargateDependency =
            StargateDependencyImpl(group, name, version)
    }
}
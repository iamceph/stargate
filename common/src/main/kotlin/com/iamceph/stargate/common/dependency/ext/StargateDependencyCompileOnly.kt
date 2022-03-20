package com.iamceph.stargate.common.dependency.ext

import com.iamceph.stargate.common.dependency.StargateDependency
import com.iamceph.stargate.common.exception.StargateException
import com.iamceph.stargate.common.extension.StargateVersionsExtension
import org.gradle.api.Action
import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.accessors.runtime.addDependencyTo
import org.gradle.kotlin.dsl.findByType

/**
 * Access point for Stargate dependencies
 */
fun DependencyHandler.compileOnly(block: StargateVersionsExtension.() -> StargateDependency): Dependency? {
    val extension = this.extensions.findByType(StargateVersionsExtension::class)
        ?: throw StargateException("Cannot find StargateVersionsExtension!")

    return compileOnly(extension.block())
}

/**
 * Adds a dependency to the 'compileOnly' configuration.
 *
 * @param dependency the Stargate dependency to be added
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.compileOnly(dependency: StargateDependency): Dependency? =
    add("compileOnly", dependency.format())

/**
 * Adds a dependency to the 'compileOnly' configuration.
 *
 * @param dependency the Stargate dependency to be added
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.compileOnly(
    dependency: StargateDependency,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this, "compileOnly", dependency.format(), dependencyConfiguration
)
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
fun DependencyHandler.implementation(block: StargateVersionsExtension.() -> StargateDependency): Dependency? {
    val extension = this.extensions.findByType(StargateVersionsExtension::class)
        ?: throw StargateException("Cannot find StargateVersionsExtension!")

    return implementation(extension.block())
}

/**
 * Adds a dependency to the 'implementation' configuration.
 *
 * @param dependency the Stargate dependency to be added
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.implementation(dependency: StargateDependency): Dependency? =
    add("implementation", dependency.format())

/**
 * Adds a dependency to the 'implementation' configuration.
 *
 * @param dependency the Stargate dependency to be added
 * @param dependencyConfiguration expression to use to configure the dependency.
 * @return The dependency.
 *
 * @see [DependencyHandler.add]
 */
fun DependencyHandler.implementation(
    dependency: StargateDependency,
    dependencyConfiguration: Action<ExternalModuleDependency>
): ExternalModuleDependency = addDependencyTo(
    this, "implementation", dependency.format(), dependencyConfiguration
)
package com.iamceph.stargate.common.dependency

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.DependencyHandlerScope

fun dependency(action: StargateDependencyBuilder.() -> Unit): StargateDependency {
    val builder = StargateDependencyBuilder();
    action.invoke(builder)
    return builder.build()
}

fun dependency(origin: StargateDependency, action: StargateDependencyBuilder.() -> Unit): StargateDependency {
    val builder = StargateDependencyBuilder(origin)
    action.invoke(builder)
    return builder.build()
}

fun DependencyHandler.stargate(dependency: StargateDependency): Any {
    return dependency.format()
}
package com.iamceph.stargate.common.dependency.ext

import com.iamceph.stargate.common.dependency.StargateDependency
import com.iamceph.stargate.common.dependency.StargateDependencyBuilder

fun starDependency(action: StargateDependencyBuilder.() -> Unit): StargateDependency {
    return StargateDependencyBuilder()
        .also(action)
        .build()
}

fun starDependency(origin: StargateDependency, action: StargateDependencyBuilder.() -> Unit): StargateDependency {
    return StargateDependencyBuilder(origin)
        .also(action)
        .build()
}
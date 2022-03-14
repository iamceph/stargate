package com.iamceph.stargate.common.dependency

internal data class StargateDependencyImpl(
    override val group: String,
    override val name: String,
    override val version: String?
) : StargateDependency {

    constructor(origin: StargateDependency)
            : this(origin.group, origin.name, origin.version)
}
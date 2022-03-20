package com.iamceph.stargate.common.dependency

internal data class StargateDependencyImpl(
    override val group: String,
    override val name: String,
    override val version: String?
) : StargateDependency
package com.iamceph.stargate.common.dependency

data class StargateDependencyBuilder(
    var group: String? = null,
    var name: String? = null,
    var version: String? = null
) {

    constructor(origin: StargateDependency): this(origin.group, origin.name, origin.version)

    fun build(): StargateDependency {
        val group = group ?: throw NullPointerException("Group is not defined.")
        val name = name ?: throw NullPointerException("Name is not defined.")
        return StargateDependencyImpl(group, name, version)
    }
}
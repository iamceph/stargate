package com.iamceph.stargate.common.dependency

data class StargateDependencyBuilder(
    var group: String? = null,
    var name: String? = null,
    var version: String? = null
) {

    constructor(origin: StargateDependency) : this(origin.group, origin.name, origin.version)

    fun build(): StargateDependency {
        return StargateDependencyImpl(
            group ?: throw NullPointerException("Group is not defined."),
            name ?: throw NullPointerException("Name is not defined."),
            version
        )
    }
}
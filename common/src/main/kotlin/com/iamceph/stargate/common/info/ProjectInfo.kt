package com.iamceph.stargate.common.info

import org.gradle.api.Project

data class ProjectInfo(
    val project: Project,
    val isSnapshot: Boolean,

)

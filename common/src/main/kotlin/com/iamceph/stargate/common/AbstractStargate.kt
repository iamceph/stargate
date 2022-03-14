package com.iamceph.stargate.common

import com.iamceph.stargate.common.dependency.dependency
import com.iamceph.stargate.common.dependency.stargate
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

abstract class AbstractStargate : Plugin<Project> {


    override fun apply(target: Project) {
        val test = dependency {
            group = "test"
            name = ""
            version = ""
        }

        target.dependencies {
            add("compileOnly", stargate(test))
        }
    }
}
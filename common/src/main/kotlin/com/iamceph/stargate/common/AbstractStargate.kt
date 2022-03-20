package com.iamceph.stargate.common

import com.iamceph.stargate.common.dependency.ext.implementation
import com.iamceph.stargate.common.dependency.ext.starDependency
import com.iamceph.stargate.common.extension.StargateExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

abstract class AbstractStargate : Plugin<Project> {

    override fun apply(target: Project) {
        val test = starDependency {
            group = "test"
            name = ""
            version = ""
        }

        target.dependencies {
            implementation { SPRING_STARTER("webflux") }
            implementation { SPRING_BOOT("")}
        }

        stargate {
            publishing {
                docker = true
                sources = true
            }
        }

        target.extensions.getByType(StargateExtension::class.java)
            .also {
                it.publishing {
                    docker = true
                    sources = true
                }
            }
    }

    fun stargate(builder: StargateExtension.() -> Unit) {

    }
}
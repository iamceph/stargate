package com.iamceph.stargate.common.extension

import com.iamceph.stargate.common.builder.PublishingBuilder
import com.iamceph.stargate.common.builder.ReleasingBuilder

class StargateExtension {
    private var publishing: PublishingBuilder? = null
    private var releasing: ReleasingBuilder? = null

    private var nebulaReleasing: Boolean = false

    fun publishing(block: PublishingBuilder.() -> Unit) {
        if (publishing == null) {
            publishing = PublishingBuilder()
        }
        publishing?.block()
    }

    fun releasing(block: ReleasingBuilder.() -> Unit) {
        if (releasing == null) {
            releasing = ReleasingBuilder()
        }
        releasing?.block()
    }

}
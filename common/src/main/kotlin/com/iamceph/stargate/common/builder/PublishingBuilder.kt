package com.iamceph.stargate.common.builder

import sun.jvm.hotspot.oops.CellTypeState.value

class PublishingBuilder {
    var sources: Boolean = false
    var springExecutable: Boolean = false
    var docker: Boolean = false
        set(value) {
            springExecutable = true
            field = value
        }
}

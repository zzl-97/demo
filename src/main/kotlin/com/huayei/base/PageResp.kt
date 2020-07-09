package com.huayei.base

data class PageResp (
    var page: Int = 0,

    var size: Int = 0,

    var data: Any? = null,

    var total: Long = 0,

    var status: Boolean = true,

    var msg: String = "OK"
)

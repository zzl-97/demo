package com.huayei.base

open class PageReq (
    var page: Int = 1, // 初始页码

    var size: Int = 10, // 每页显示行数

    var filed: String? = null, // 排序字段

    var order: String = "desc" // 排序方式 desc-倒序  asc-升序
)

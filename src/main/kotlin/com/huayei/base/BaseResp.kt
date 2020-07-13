package com.huayei.base

/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/10 10:15
* @Since 1.0
*
*/
data class BaseResp (

    var status: Int = 0,

    var message: String = "OK",

    var data: Any? = null
)
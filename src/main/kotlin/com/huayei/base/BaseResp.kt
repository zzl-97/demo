package com.huayei.base

/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/10 10:15
* @Since 1.0
*
*/
data class BaseResp (

    var status: Int = 0, //状态 0成功》1失败

    var message: String = "OK", //信息

    var data: Any? = null //对象
)
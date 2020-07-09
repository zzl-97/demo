package com.huayei.systemManagement.dto

import com.huayei.systemManagement.entity.User
import java.sql.Date
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


data class DTOUser(
    var userId: Long? = null, //用户ID
    var userName: String? = null, //用户名
    //var resTime: String? = null, //注册时间
    var resTime: Date? = null, //注册时间
    var type: Int? = null, //类型  0 学生 1老师
    var STATE: Int? = null,//状态  0禁用 1 启用  2删除
    var roleId: Int? = null,//角色Id
    var message: String? = null //返回前台得信息
) {
    //dto转实体
    fun entity(): User {
        return User(
            userId = userId,
            userName = userName,
            resTime = resTime,
            type = type,
            STATE = STATE,
            roleId = roleId
        )
    }
}
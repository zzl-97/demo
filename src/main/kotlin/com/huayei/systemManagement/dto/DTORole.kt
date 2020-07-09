package com.huayei.systemManagement.dto

import com.huayei.systemManagement.entity.Role
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


data class DTORole(

    var roleId: Long? = null,
    var roleName: String? = null,
    var message: String? = null
) {

    fun entity():Role{

        return Role(
            roleId = roleId,
            roleName = roleName
        )
    }
}
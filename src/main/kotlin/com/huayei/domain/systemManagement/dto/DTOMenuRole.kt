package com.huayei.domain.systemManagement.dto

import com.huayei.domain.systemManagement.entity.MenuRole
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


data class DTOMenuRole(

    var menuUserId: Long? = null,
    var menuId: Long? = null,
    var roleId: Long? = null,
    var message: String? = null,
    var menuIds: Array<Long>? = null



) {

    fun entity():MenuRole{

        return MenuRole(
            roleId = roleId,
            menuId =  menuId
        )
    }

}
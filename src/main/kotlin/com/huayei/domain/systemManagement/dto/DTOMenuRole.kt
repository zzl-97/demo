package com.huayei.domain.systemManagement.dto

import com.huayei.domain.systemManagement.entity.MenuRole
import javax.validation.constraints.NotNull

/**
*@Description 菜单与角色的中间表dto
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


data class DTOMenuRole(

    @get:NotNull
    var menuUserId: Long? = null,
    @get:NotNull
    var menuId: Long? = null,
    @get:NotNull
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
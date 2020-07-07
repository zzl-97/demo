package com.huayei.systemManagement.DTO

import com.huayei.systemManagement.entity.MenuRole

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
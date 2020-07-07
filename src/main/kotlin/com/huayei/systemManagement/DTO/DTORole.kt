package com.huayei.systemManagement.DTO

import com.huayei.systemManagement.entity.Role

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
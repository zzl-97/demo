package com.huayei.domain.systemManagement.dto

import com.huayei.domain.systemManagement.entity.Role
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 *@Description 角色实体的DTO
 *Author zzl@huayei.com
 *Date 2020/7/7 18:19
 *@Since 1.0
 **/
data class DTORole(
    @get: NotNull
    var roleId: Long? = null,
    @get: NotBlank
    @get: Size(max = 120)
    var roleName: String? = null

) {

    fun entity(): Role {

        return Role(
            roleId = roleId,
            roleName = roleName
        )
    }
}
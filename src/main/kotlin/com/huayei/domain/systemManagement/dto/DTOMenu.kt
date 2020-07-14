package com.huayei.domain.systemManagement.dto

import com.huayei.domain.systemManagement.entity.Menu
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size
import kotlin.math.max

/**
*@Description 菜单的实体Dto
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/
data class DTOMenu(
    @get: NotNull
    var menuId: Long? = null,
    @get: NotBlank
    @get: Size(max = 256)
    var menuName: String? = null,
    var message: String? = null
) {
    fun entity(): Menu {

        return Menu(
            menuId = menuId,
            menuName = menuName
        )
    }
}
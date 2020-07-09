package com.huayei.systemManagement.dto

import com.huayei.systemManagement.entity.Menu
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


data class DTOMenu(

    var menuId: Long? = null,
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
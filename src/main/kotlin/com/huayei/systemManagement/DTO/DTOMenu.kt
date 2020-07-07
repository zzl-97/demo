package com.huayei.systemManagement.DTO

import com.huayei.systemManagement.entity.Menu

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
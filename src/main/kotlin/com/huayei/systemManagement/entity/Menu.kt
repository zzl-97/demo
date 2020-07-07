package com.huayei.systemManagement.entity

import com.huayei.systemManagement.DTO.DTOMenu
import com.sun.javafx.beans.IDProperty
import javax.persistence.*
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Entity
@Table(name = "t_menu")
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自定义序列开始值
    @SequenceGenerator(name = "initialValue = 100")
    var menuId: Long? = null,
    var menuName: String? = null,
    var url: String? = null,
    var menuState: Int? = null,
    var fid: Int? = null
) {

    fun dto():DTOMenu{

        return DTOMenu(
            menuId =  menuId,
            menuName = menuName
        )
    }
}
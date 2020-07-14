package com.huayei.domain.systemManagement.entity

import com.huayei.domain.systemManagement.dto.DTOMenu
import javax.persistence.*
/**
*@Description 菜单实体
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
    /**
     * 实体转DTO
     */
    fun dto():DTOMenu{
        return DTOMenu(
            menuId =  menuId,
            menuName = menuName
        )
    }
}
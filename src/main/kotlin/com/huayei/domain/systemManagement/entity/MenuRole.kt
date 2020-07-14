package com.huayei.domain.systemManagement.entity

import com.huayei.domain.systemManagement.dto.DTOMenuRole
import javax.persistence.*
/**
*@Description 菜单与角色的实体
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Entity
@Table(name = "t_menurole")
data class MenuRole(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自定义序列开始值
    @SequenceGenerator(name = "initialValue = 100")
    var menuUserId: Long? = null,
    var menuId: Long? = null,
    var roleId: Long? = null

) {
    /**
     * 实体转DTO
     */
    fun dto():DTOMenuRole{
        return DTOMenuRole(
            menuId = menuId,
            roleId = roleId

        )
    }
}
package com.huayei.systemManagement.entity

import com.huayei.systemManagement.DTO.DTOMenuRole
import javax.persistence.*
/**
*@Description TODO
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

    fun dto():DTOMenuRole{

        return DTOMenuRole(
            menuId = menuId,
            roleId = roleId

        )
    }
}
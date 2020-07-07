package com.huayei.systemManagement.entity

import com.huayei.systemManagement.DTO.DTOMenuRole
import javax.persistence.*

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
package com.huayei.domain.systemManagement.entity

import com.huayei.domain.systemManagement.dto.DTORole
import javax.persistence.*
/**
*@Description 角色的实体
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Entity
@Table(name = "t_role")
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自定义序列开始值
    @SequenceGenerator(name = "initialValue = 100")
    var roleId: Long? = null,
    var roleName: String? = null
) {
    /**
     * 实体转DTO
     */
    fun dto():DTORole{
        return  DTORole(
           roleId = roleId,
            roleName = roleName
        )
    }
}
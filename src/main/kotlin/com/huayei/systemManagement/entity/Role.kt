package com.huayei.systemManagement.entity

import com.huayei.systemManagement.DTO.DTORole
import javax.persistence.*

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

    fun dto():DTORole{

        return  DTORole(
           roleId = roleId,
            roleName = roleName
        )
    }
}
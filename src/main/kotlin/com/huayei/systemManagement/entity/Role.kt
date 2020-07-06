package com.huayei.systemManagement.entity

import javax.persistence.*

@Entity
@Table(name = "t_role")
data class Role(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自定义序列开始值
    @SequenceGenerator(name = "initialValue = 100")
    var roleId: Int? = null,
    var roleName: String? = null
) {
}
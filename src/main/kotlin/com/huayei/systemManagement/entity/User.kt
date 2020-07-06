package com.huayei.systemManagement.entity

import com.fasterxml.jackson.annotation.JsonFormat
import com.huayei.systemManagement.DTO.DTOUser
import org.springframework.data.annotation.CreatedDate

import java.sql.Date

import javax.persistence.*


@Entity
@Table(name = "t_user")

data class User(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    //自定义序列开始值
    @SequenceGenerator(name= "initialValue = 100")
    var userId: Long? = null, //用户ID
    var userName: String? = null, //用户名
    var password: String? = null, //用户密码
    @CreatedDate
    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss")//设置添加得格式
    var resTime: Date? = null, //注册时间

    var type: Int? = null, //类型  0 学生 1老师
    var STATE: Int? = null,//状态  0禁用 1 启用  2删除
    var roleId: Int? = null//角色Id
) {
    //实体转dto
    fun dto():DTOUser{

        return DTOUser(
            userId = userId,
            userName = userName,
            resTime = resTime,
            type = type,
            STATE = STATE,
            roleId = roleId
        )


    }
}
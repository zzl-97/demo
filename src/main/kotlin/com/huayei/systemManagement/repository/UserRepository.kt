package com.huayei.systemManagement.repository

import com.huayei.systemManagement.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional
import java.util.*
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Repository
@Transactional(readOnly = true)
interface UserRepository :JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    //登陆查询用户存不存在
    fun findByUserNameAndPassword(userName: String?, password: String?):User


}
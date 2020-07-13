package com.huayei.domain.systemManagement.repository

import com.huayei.domain.systemManagement.entity.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Repository
@Transactional(readOnly = true)
interface UserRepository :JpaRepository<User,Long>, JpaSpecificationExecutor<User> {

    /**
     * 登入查询
     * @param userName 用户名，password 密码
     * return User对象
     */
    fun findByUserNameAndPassword(userName: String?, password: String?):User


}
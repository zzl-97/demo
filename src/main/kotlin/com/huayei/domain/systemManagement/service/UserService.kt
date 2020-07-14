package com.huayei.domain.systemManagement.service

import com.huayei.domain.systemManagement.repository.UserRepository
import org.springframework.stereotype.Service
/**
*@Description 用户的服务层
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/
@Service
class UserService(var userRepository: UserRepository) {
    /**
     * 根据用户名密码进行查询是否存在
     * return User对象
     */
    fun getUser(userName: String, userPassword: String) =
        userRepository.findByUserNameAndPassword(userName, userPassword)
}
package com.huayei.systemManagement.service

import com.huayei.systemManagement.repository.UserRepository
import org.springframework.stereotype.Service
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Service
class UserService(

    var userRepository: UserRepository
) {
    //根据用户名查询
    fun selectUser(userName: String?, userPassword: String?) =
        userRepository.findByUserNameAndPassword(userName, userPassword);
}
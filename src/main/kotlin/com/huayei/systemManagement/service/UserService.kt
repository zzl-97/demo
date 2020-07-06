package com.huayei.systemManagement.service

import com.huayei.systemManagement.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(

    var userRepository: UserRepository
) {
    //根据用户名查询
    fun selectUser(userName: String?, userPassword: String?) =
        userRepository.findByUserNameAndPassword(userName, userPassword);
}
package com.huayei.systemManagement.controller

import com.huayei.systemManagement.DTO.DTOUser
import com.huayei.systemManagement.entity.User
import com.huayei.systemManagement.service.UserService
import org.hibernate.sql.Update
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.annotation.Resource

@RestController
class UserController(

    @Resource
    var userService: UserService

) {
    //登陆得方法
    @PostMapping("/Login.ait")
    fun selectUser(@RequestBody user: User): DTOUser {
        return userService.selectUser(user.userName, user.password).dto();
    }

    //注册用户
    @PostMapping("/register.ait")
    fun registerUser(@RequestBody user: User): DTOUser {
        if (user.password == null || user.password.equals("") ) {
            return DTOUser(
                userName = user.userName,
                message = "密码不能为空"
            );
        }
        userService.userRepository.save(user);
        return DTOUser(
            userName = user.userName,
            message = "注册成功"
        );
    }

    //修改用户
    @PutMapping("/updateUser.ait/{id}")
    fun updateUser( @PathVariable id: Long ,@RequestBody user: User): DTOUser {

        if (user.password == null || user.password.equals("")) {
            return DTOUser(
                userName = user.userName,
                message = "修改密码不能为空"
            );
        }
        userService.userRepository.findById(id).map {
            it.userName = user.userName
            it.password = user.password
            it.roleId = user.roleId
            userService.userRepository.save(it)
        }
        return DTOUser(
            message = "修改成功"
        )
    }

    //删除用户
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): DTOUser {
        userService.userRepository.findById(id).map {
            userService.userRepository.deleteById(id)
        }
        return DTOUser(
            message = "删除成功"
        )
    }

}
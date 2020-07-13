package com.huayei.controller.systemManagement

import com.huayei.base.BaseResp
import com.huayei.domain.systemManagement.dto.DTOUser
import com.huayei.domain.systemManagement.entity.User
import com.huayei.domain.systemManagement.service.UserService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/7 18:19
 *@Since 1.0
 **/
@RestController
@CrossOrigin
class UserController(var userService: UserService) {
    /**
     * 登陆验证的方法
     * @param user 用户对象
     * return DTOUser对象
     */
    @PostMapping("/Login.ait")
    fun getUser(@RequestBody user: User): DTOUser {
        return userService.getUser(user.userName, user.password).dto();
    }

    /**
     * 新增注册用户的方法
     * @param user 用户对象
     */
    @PostMapping("/register.ait")
    fun registerUser(@RequestBody user: User): BaseResp {
        if (user.password == null || user.password.equals("")) {
            return BaseResp(
                message = "密码不能为空"
            );
        }
        userService.userRepository.save(user);

        return BaseResp(data = user, message = "注册成功");
    }

    /**
     * 修改用户信息
     * @param id 用户ID
     */
    @PutMapping("/updateUser.ait/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody user: User): BaseResp {

        if (user.password == null || user.password.equals("")) {
            return BaseResp(message = "修改密码不能为空");
        }
        userService.userRepository.findById(id).map {
            it.userName = user.userName
            it.password = user.password
            it.roleId = user.roleId
            userService.userRepository.save(it)
        }.orElse(return BaseResp(message = "修改失败"));

        return BaseResp(message = "修改成功")
    }

    /**
     * 删除用户
     * @param id 用户ID
     */
    @DeleteMapping("/delete/{id}")
    fun deleteUser(@PathVariable id: Long): BaseResp {
        userService.userRepository.findById(id).map {
            userService.userRepository.deleteById(id)
        }.orElse(return BaseResp(message = "删除失败"))

        return BaseResp(message = "删除成功")
    }

    /**
     * 用户权限操作 禁用启用删除
     * @param id 用户ID state 修改状态
     */
    @PutMapping("/updateState.ait/{id}")
    fun updateState(@PathVariable id: Long, @RequestParam state: Int): BaseResp {
        userService.userRepository.findById(id).map {
            it.STATE = state
            userService.userRepository.save(it)
        }.orElse(return BaseResp(message = "状态修改失败"))

        return BaseResp(message = "用户状态修改成功")
    }

}
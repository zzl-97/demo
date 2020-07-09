package com.huayei.systemManagement.controller

import com.huayei.systemManagement.dto.DTORole
import com.huayei.systemManagement.entity.Role
import com.huayei.systemManagement.service.RoleService
import org.springframework.web.bind.annotation.*

/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:18
*@Since 1.0
**/


@RestController
class RoleController(

    var roleService: RoleService
) {

    //查询角色
    @PostMapping("/selectRoleAll")
    fun selectRole(): List<Role> {

        return roleService.roleRepository.findAll();
    }

    //新增角色
    @PostMapping("/addRole")
    fun addRole(@RequestBody role: Role): DTORole {
        if (role.roleName.equals("")) {
            return DTORole(
                message = "输入有效角色名"
            )
        }
        roleService.roleRepository.save(role);
        return DTORole(
            roleName = role.roleName,
            message = "新增成功"
        )
    }

    //修改角色
    @PutMapping("/updateRole/{id}")
    fun updateRole(@PathVariable id: Long, @RequestBody role: Role): DTORole {
        roleService.roleRepository.findById(id).map {
            it.roleName = role.roleName
            roleService.roleRepository.save(it)
        }

        return DTORole(
            message = "修改成功"
        )
    }


    //删除角色
    @DeleteMapping("/deleteRole")
    fun delete():DTORole{

        return DTORole()
    }

}
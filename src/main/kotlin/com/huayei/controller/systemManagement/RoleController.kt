package com.huayei.controller.systemManagement

import com.huayei.base.BaseResp
import com.huayei.domain.systemManagement.dto.DTORole
import com.huayei.domain.systemManagement.entity.Role
import com.huayei.domain.systemManagement.repository.RoleRepository
import com.huayei.domain.systemManagement.service.RoleService
import org.springframework.web.bind.annotation.*

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/7 18:18
 *@Since 1.0
 **/
@RestController
@CrossOrigin
class RoleController(val roleService: RoleService, val roleRepository: RoleRepository) {

    /**
     * 查询所有角色
     */
    @PostMapping("/getRoleAll")
    fun getRole(): BaseResp {
        return BaseResp(data = roleRepository.findAll());
    }

    /**
     * 新增角色
     * @param role 角色对象
     */
    @PostMapping("/addRole")
    fun addRole(@RequestBody role: DTORole): BaseResp {
        if (role.roleName.equals("")) {
            return BaseResp(message = "输入有效角色名")
        }
        roleService.roleRepository.save(role.entity());
        return BaseResp(message = "新增成功")
    }


    /**
     * 修改角色信息
     * @param id 角色Id
     */
    @PutMapping("/updateRole/{id}")
    fun updateRole(@PathVariable id: Long, @RequestBody role: Role): BaseResp {
        roleService.roleRepository.findById(id).map {
            it.roleName = role.roleName
            roleService.roleRepository.save(it)
        }.orElse(return BaseResp(message = "修改失败"))

        return BaseResp(message = "修改成功")
    }


    //删除角色
    @DeleteMapping("/deleteRole")
    fun delete(): DTORole {
        return DTORole()
    }

}
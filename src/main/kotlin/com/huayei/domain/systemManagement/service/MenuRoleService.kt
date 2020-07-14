package com.huayei.domain.systemManagement.service

import com.huayei.domain.systemManagement.repository.MenuRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
/**
*@Description 角色与菜单中间表的服务层
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/
@Service
@Transactional
class MenuRoleService(var menuRoleRepository: MenuRoleRepository) {

    fun deleteRole(roleId :Long) = menuRoleRepository.deleteByRoleId(roleId)

}
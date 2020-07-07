package com.huayei.systemManagement.service

import com.huayei.systemManagement.entity.MenuRole
import com.huayei.systemManagement.repository.MenuRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Service
@Transactional
class MenuRoleService(

    var menuRoleRepository: MenuRoleRepository
) {

    fun delteteRole(roleId :Long) = menuRoleRepository.deleteByRoleId(roleId)


}
package com.huayei.systemManagement.service

import com.huayei.systemManagement.entity.MenuRole
import com.huayei.systemManagement.repository.MenuRoleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MenuRoleService(

    var menuRoleRepository: MenuRoleRepository
) {

    fun delteteRole(roleId :Long) = menuRoleRepository.deleteByRoleId(roleId)


}
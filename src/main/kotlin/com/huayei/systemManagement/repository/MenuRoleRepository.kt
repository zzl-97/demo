package com.huayei.systemManagement.repository

import com.huayei.systemManagement.entity.MenuRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor

interface MenuRoleRepository : JpaRepository<MenuRole, Long>, JpaSpecificationExecutor<MenuRole> {

    //根据roleID删除
    fun deleteByRoleId(roleId: Long?);
}
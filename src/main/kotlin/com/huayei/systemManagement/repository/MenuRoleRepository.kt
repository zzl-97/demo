package com.huayei.systemManagement.repository

import com.huayei.systemManagement.entity.MenuRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


interface MenuRoleRepository : JpaRepository<MenuRole, Long>, JpaSpecificationExecutor<MenuRole> {

    //根据roleID删除
    fun deleteByRoleId(roleId: Long?);
}
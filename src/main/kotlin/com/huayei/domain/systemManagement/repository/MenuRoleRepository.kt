package com.huayei.domain.systemManagement.repository

import com.huayei.domain.systemManagement.entity.MenuRole
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
*@Description 菜单与角色的DAO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/

@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
interface MenuRoleRepository : JpaRepository<MenuRole, Long>, JpaSpecificationExecutor<MenuRole> {

    /**
     * 根据角色Id删除角色
     * @param roleId 角色ID
     */
    fun deleteByRoleId(roleId: Long?);
}
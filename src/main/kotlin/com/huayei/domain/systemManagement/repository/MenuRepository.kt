package com.huayei.domain.systemManagement.repository

import com.huayei.domain.systemManagement.entity.Menu
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository

/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
//菜单的数据库操作
interface MenuRepository : JpaRepository<Menu, Long>, JpaSpecificationExecutor<Menu> {

    /**
     * 根据用户Id查询菜单
     * @param userId 用户菜单
     * return 菜单集合
     */
    @Query( value = "select b from MenuRole a left join Menu b on a.menuId = b.menuId left join Role c on " +
                " c.roleId = a.roleId left join User d on c.roleId = d.roleId where d.userId = ?1")
    fun selectMenu(userId: Long?): List<Menu>

}
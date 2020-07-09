package com.huayei.systemManagement.repository

import com.huayei.systemManagement.entity.Menu
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

    @Query( value = "select b from MenuRole a left join Menu b on a.menuId = b.menuId left join Role c on " +
                " c.roleId = a.roleId left join User d on c.roleId = d.roleId where d.userId = ?1")
    fun selectMenu(userId: Long?): List<Menu>

}
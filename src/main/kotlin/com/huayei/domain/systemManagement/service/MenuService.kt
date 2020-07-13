package com.huayei.domain.systemManagement.service

import com.huayei.domain.systemManagement.repository.MenuRepository
import org.springframework.stereotype.Service
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


@Service
class MenuService(
    var menuRepository: MenuRepository
) {
    /**
     * 根据用户ID查询拥有的菜单
     * @param userId 用户Id
     * return 菜单
     */
    fun getMenu(userId :Long ) = menuRepository.selectMenu(userId );
}
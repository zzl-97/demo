package com.huayei.systemManagement.service

import com.huayei.systemManagement.repository.MenuRepository
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
    //根据用户Id来查询 菜单
    fun selectMenu(menuId :Long ) = menuRepository.selectMenu(menuId );
}
package com.huayei.systemManagement.service

import com.huayei.systemManagement.repository.MenuRepository
import org.springframework.stereotype.Service

@Service
class MenuService(
    var menuRepository: MenuRepository
) {
    //根据用户Id来查询 菜单
    fun selectMenu(menuId :Long ) = menuRepository.selectMenu(menuId );
}
package com.huayei.systemManagement.controller

import com.huayei.systemManagement.dto.DTOMenu
import com.huayei.systemManagement.dto.DTOMenuRole
import com.huayei.systemManagement.entity.Menu
import com.huayei.systemManagement.entity.MenuRole
import com.huayei.systemManagement.service.MenuRoleService
import com.huayei.systemManagement.service.MenuService
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/7 18:19
 *@Since 1.0
 **/

@RestController
@CrossOrigin
class MenuController(
    var menuService: MenuService,
    var menuRoleService: MenuRoleService,
    val menuRepository: MenuRoleService

) {
    /**
     * 根据id查询用户得菜单
     */
    @PutMapping("/selectMenu.ait/{id}")
    fun selectMenu(@PathVariable id: Long): List<DTOMenu> {
        return menuService.selectMenu(id).map {
            it.dto()
        };

    }

    /**
     * 查询顶级菜单
     */
    @PostMapping("/selectMenuTop")
    fun selectMenuTop(): Optional<DTOMenu>? {

        return menuService.menuRepository.findById(0).map {
            it.dto();
        }
    }

    /**
     * 根据父类ID查询字类ID
     */
    @PostMapping("/selectMenuUnder/{id}")
    fun selectMenuUnder(@PathVariable id: Long): Optional<DTOMenu>? {

        return menuService.menuRepository.findById(id).map {
            it.dto();
        }
    }

    /**
     * 添加菜单
     */

    @PostMapping("/addMenu")
    fun addMenu(@RequestBody menu: Menu): DTOMenu {
        menuService.menuRepository.save(menu);
        return DTOMenu(message = "添加菜单成功")
    }

    /**
     *  修改菜单
     */
    @PutMapping()
    fun updateMenu(@PathVariable id: Long, @RequestBody menu: Menu): DTOMenu {
        //根据id查询菜单
        menuService.menuRepository.findById(id).map {
            //遍历赋值
            it.menuName = menu.menuName
            it.url = menu.url
            it.menuState = menu.menuState
            it.fid = menu.fid
            menuService.menuRepository.save(it)
        }
        return DTOMenu(message = "修改成功")
    }

    /**
     * 修改角色的菜单权限
     */

    @PutMapping("/authority")
    fun authority(@RequestBody dtoMenuRole: DTOMenuRole): DTOMenuRole {
        //定义一个集合用于批量插入
        var list = arrayListOf<MenuRole>()
        //判断ID不为空删除这个角色的ID
        dtoMenuRole.roleId?.let {
            menuRoleService.delteteRole(it)
        }
        //遍历
        for (item in dtoMenuRole.menuIds!!) {
            var menuRole: MenuRole = MenuRole();
            //将Id赋值给menuRole
            menuRole.roleId = dtoMenuRole.roleId
            menuRole.menuId = item
            list.add(menuRole);
        }
        //执行添加的方法
        menuRoleService.menuRoleRepository.saveAll(list)
        return DTOMenuRole(message = "修改成功")
    }


}
package com.huayei.controller.systemManagement

import com.huayei.base.BaseResp
import com.huayei.domain.systemManagement.dto.DTOMenu
import com.huayei.domain.systemManagement.dto.DTOMenuRole
import com.huayei.domain.systemManagement.entity.Menu
import com.huayei.domain.systemManagement.entity.MenuRole
import com.huayei.domain.systemManagement.repository.MenuRepository
import com.huayei.domain.systemManagement.service.MenuRoleService
import com.huayei.domain.systemManagement.service.MenuService
import org.springframework.web.bind.annotation.*
import java.util.*

/**
 *@Description 菜单Controller
 *Author zzl@huayei.com
 *Date 2020/7/7 18:19
 *@Since 1.0
 **/

@RestController
@CrossOrigin
class MenuController(
    val menuService: MenuService,
    val menuRoleService: MenuRoleService,
    val menuRepository: MenuRepository
) {
    /**
     * 根据id查询用户得菜单
     * @param id 用户ID
     * return 菜单集合
     */
    @PutMapping("/selectMenu.ait/{id}")
    fun getMenu(@PathVariable id: Long): BaseResp {
        return BaseResp(data = menuService.getMenu(id))
    }

    /**
     * 查询顶级菜单
     * @param id = 0 顶级菜单ID
     * return 菜单集合对象
     */
    @PostMapping("/selectMenuTop")
    fun getMenuTop(): BaseResp {
        return menuRepository.findById(0).map {
            BaseResp(status = 0, message = "ok", data = it)
        }.orElse( BaseResp(status = 0, message = "no",data = null))
    }

    /**
     * 根据父类ID查询子类
     * @param id 父类ID
     * return 菜单集合对象
     */
    @PostMapping("/selectMenuUnder/{id}")
    fun getMenuUnder(@PathVariable id: Long): BaseResp {
        return menuRepository.findById(id).map {
            BaseResp(status = 0, message = "ok", data = it)
        }.orElse( BaseResp(status = 0, message = "no",data = null))
    }

    /**
     * 添加菜单
     * @param menu 菜单对象
     */
    @PostMapping("/addMenu")
    fun addMenu(@RequestBody menu: DTOMenu): BaseResp {
        menuService.menuRepository.save(menu.entity());
        return BaseResp(status = 0, message = "添加菜单成功")
    }

    /**
     *  根据菜单ID修改
     *  @param id 菜单Id
     */
    @PutMapping()
    fun updateMenu(@PathVariable id: Long, @RequestBody menu: Menu): BaseResp {
        //根据id查询菜单
        return   menuService.menuRepository.findById(id).map {
            //遍历赋值
            it.menuName = menu.menuName
            it.url = menu.url
            it.menuState = menu.menuState
            it.fid = menu.fid
            menuService.menuRepository.save(it)
            BaseResp(status = 0,message = "修改成功")
        }.orElse( BaseResp(status = 1,message = "修改失败"))
    }

    /**
     * 修改角色的菜单权限
     */
    @PutMapping("/authority")
    fun authority(@RequestBody dtoMenuRole: DTOMenuRole): BaseResp {
        //定义一个集合用于批量插入
        var list = arrayListOf<MenuRole>()
        //判断ID不为空删除这个角色的ID
        dtoMenuRole.roleId?.let {
            menuRoleService.deleteRole(it)
        }
        //遍历
        for (item in dtoMenuRole.menuIds!!) {
            var menuRole: MenuRole = MenuRole();
            //将Id赋值给menuRole
            menuRole.roleId = dtoMenuRole.roleId
            menuRole.menuId = item
            list.add(menuRole)
        }
        //执行添加的方法
        menuRoleService.menuRoleRepository.saveAll(list)
        return BaseResp(status = 0,message = "修改成功")
    }


}
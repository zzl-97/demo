package com.huayei.domain.systemManagement.service

import com.huayei.domain.systemManagement.repository.RoleRepository
import org.springframework.stereotype.Service
/**
*@Description 角色服务层
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/
@Service
class RoleService (var roleRepository: RoleRepository){}
package com.huayei.systemManagement.repository

import com.huayei.systemManagement.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/


interface RoleRepository :JpaRepository<Role,Long>,JpaSpecificationExecutor<Role>{


}
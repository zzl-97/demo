package com.huayei.domain.systemManagement.repository

import com.huayei.domain.systemManagement.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
*@Description TODO
*Author zzl@huayei.com
*Date 2020/7/7 18:19
*@Since 1.0
**/

@Repository
@org.springframework.transaction.annotation.Transactional(readOnly = true)
interface RoleRepository :JpaRepository<Role,Long>,JpaSpecificationExecutor<Role>{


}
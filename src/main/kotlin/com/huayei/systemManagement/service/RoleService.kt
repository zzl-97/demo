package com.huayei.systemManagement.service

import com.huayei.systemManagement.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService (

    var roleRepository: RoleRepository
){

}
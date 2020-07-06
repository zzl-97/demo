package com.huayei.systemManagement.entity

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "t_menuuser")
data class MenuUser (
    @Id
    var menuUserId: Int? = null,
    var menuId: Int? = null,
    var userId: Int? = null

){

}
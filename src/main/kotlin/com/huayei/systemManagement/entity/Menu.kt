package com.huayei.systemManagement.entity

import com.sun.javafx.beans.IDProperty
import javax.persistence.*

@Entity
@Table(name = "t_menu")
data class Menu(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    //自定义序列开始值
    @SequenceGenerator(name = "initialValue = 100")
    var menuId: Int? = null,
    var menuName: String? = null,
    var url: String? = null,
    var menuState: Int? = null
) {
}
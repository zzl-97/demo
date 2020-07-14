package com.huayei.domain.course.entity

import javax.persistence.*

/**
 *@Description 用户与课程的关系表
 *Author zzl@huayei.com
 *Date 2020/7/8 10:49
 *@Since 1.0
 **/

@Entity
@Table(name = "t_course_user")
data class CourseUser(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var courseUserId: Long? = null,

    var courseId: Int? = null,

    var userId: Long? = null
) {


}
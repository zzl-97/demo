package com.huayei.testQuestions.event

import com.huayei.systemManagement.entity.User
import com.huayei.testQuestions.dto.CourseDto
import javax.persistence.*
/**
* @Description TODO
* @Author liuh@huayei.com
* @Date 2020/7/6 15:46
* @Since 1.0
*
*/
@Entity
@Table(name = "COURSES")
data class Course(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var courseId : Int ?= null,// 课程id

    var courseName : String ?= null,// 课程名

    var coursePicture : String ?= null,// 课程图片

    var courseIntroduce : String ?= null,// 课程介绍

    var userId: Long ?= null// 用户id

) {
    fun dto() : CourseDto{
        return CourseDto( courseId = courseId, courseName = courseName, coursePicture = coursePicture,
            courseIntroduce = courseIntroduce, userId = userId)
    }
}
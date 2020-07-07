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
    var courseId : Int ?= null,

    var courseName : String ?= null,

    var coursePicture : String ?= null,

    var courseIntroduce : String ?= null,

    var userId: Long ?= null

) {
    fun dto() : CourseDto{
        return CourseDto( courseId = courseId, courseName = courseName, coursePicture = coursePicture,
            courseIntroduce = courseIntroduce, userId = userId)
    }
}
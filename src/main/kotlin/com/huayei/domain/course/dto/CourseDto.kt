package com.huayei.testQuestions.dto

import com.huayei.testQuestions.event.Course
import com.sun.istack.NotNull
import javax.validation.constraints.Size

/**
 * @Description 课程的DTO
 * @Author liuh@huayei.com
 * @Date 2020/7/6 15:46
 * @Since 1.0
 *
 */
data class CourseDto(


    var courseId: Long? = null, //课程ID
    @get: Size(max = 256)
    var courseName: String? = null, //课程名字

    var coursePicture: String? = null, //课件

    var courseIntroduce: String? = null, //课程结束

    var userId: Long? = null, //用户ID

    var message: String? = null
) {
    fun entity(): Course {
        return Course(courseName = courseName, coursePicture = coursePicture, courseIntroduce = courseIntroduce)
    }
}
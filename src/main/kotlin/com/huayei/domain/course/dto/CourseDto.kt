package com.huayei.testQuestions.dto

import com.huayei.testQuestions.event.Course
import com.sun.istack.NotNull
import javax.validation.constraints.Size

/**
 * @Description TODO
 * @Author liuh@huayei.com
 * @Date 2020/7/6 15:46
 * @Since 1.0
 *
 */
data class CourseDto(


    var courseId: Int? = null,
    @get: Size(max = 256)
    var courseName: String? = null,

    var coursePicture: String? = null,

    var courseIntroduce: String? = null,

    var userId: Long? = null,

    var message: String? = null
) {
    fun entity(): Course {
        return Course(courseName = courseName, coursePicture = coursePicture, courseIntroduce = courseIntroduce)
    }
}
package com.huayei.testQuestions.event

import com.huayei.testQuestions.dto.CourseDto
import java.util.*
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
    var courseId: Long? = null, // 课程id

    @Column(length = 64) // length default 255
    var courseName: String? = null, // 课程名

    var coursePicture: String? = null, // 课程图片

    var courseIntroduce: String? = null, // 课程介绍

    var userId: Long? = null, // 用户id

    // sonarLint  代码质量检测  detekt 代码质量检测  jacoco 测试覆盖率
    var createDate: Date? = null // 创建时间

) {
    fun dto(): CourseDto {
        return CourseDto(
            courseId = courseId, courseName = courseName, coursePicture = coursePicture,
            courseIntroduce = courseIntroduce, userId = userId
        )
    }

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    fun getId(): Long? {
        return courseId
    }
}
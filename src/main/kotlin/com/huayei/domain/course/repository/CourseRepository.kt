package com.huayei.domain.course.repository

import com.huayei.testQuestions.event.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *@Description 课程DAO
 *Author zzl@huayei.com
 *Date 2020/7/8 9:15
 *@Since 1.0
 **/
@Repository
@Transactional(readOnly = true)
interface CourseRepository : JpaRepository<Course, Long>, JpaSpecificationExecutor<Course> {

    //根据名字来查询课程是否存在
    fun findByCourseName(CourseName: String?): Course?

    /**
     * 根据课程名称判断课程是否存在
     * @param name 课程名称
     * @return true-存在 否则 false
     */
    fun existsByCourseName(name: String): Boolean

    /**
     *  查询所有的课程 添加章节用
     */
    fun findAllBy(): List<Course>
}
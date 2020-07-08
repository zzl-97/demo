package com.huayei.course.repository

import com.huayei.testQuestions.event.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 9:15
 *@Since 1.0
 **/


@Repository
@Transactional(readOnly = true)
interface CourseRepository : JpaRepository<Course, Int>, JpaSpecificationExecutor<Course> {

    //根据名字来查询课程是否存在
    fun findByCourseName(CourseName: String?):Course?;

    //查询所有的课程 添加章节用
    fun findAllBy():List<Course>;
}
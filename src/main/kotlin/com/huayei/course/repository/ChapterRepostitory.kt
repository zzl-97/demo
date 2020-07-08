package com.huayei.course.repository

import com.huayei.course.event.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:15
 *@Since 1.0
 **/

@Repository
interface ChapterRepostitory : JpaRepository<Chapter, Int>, JpaSpecificationExecutor<Chapter> {

    //根据章节名字查询
    fun findByChapterName(Chapter: String?): Chapter?;

    //根据 课程ID 来查询
    fun findByCourseId(courseId: Int): List<Chapter>;
}
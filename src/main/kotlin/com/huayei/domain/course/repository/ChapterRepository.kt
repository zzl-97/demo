package com.huayei.domain.course.repository

import com.huayei.domain.course.entity.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 *@Description 章节DAO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:15
 *@Since 1.0
 **/
@Repository
interface ChapterRepository : JpaRepository<Chapter, Int>, JpaSpecificationExecutor<Chapter> {

    /**
     * 根据章节名字来查询
     * @param Chapter 章节名
     * return Optional<Chapter>非空章节对象
     */
    // SELECT * FROM CHAPTER C WHERE C.CHAPTER_NAME =
    fun findByChapterName(Chapter: String): Optional<Chapter>

    /**
     * 根据章节名称判断章节是否存在
     * @param name 章节名称
     * @return true-存在 否则 false
     */
    fun existsByChapterName(name: String): Boolean

    /**
     * 根据课程ID来查询章节
     * @param courseId 课程ID
     * return List<Chapter>对象
     */
    fun findByCourseId(courseId: Long): List<Chapter>
}
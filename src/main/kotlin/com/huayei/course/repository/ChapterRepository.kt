package com.huayei.course.repository

import com.huayei.course.entity.Chapter
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.*

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:15
 *@Since 1.0
 **/

@Repository
interface ChapterRepository : JpaRepository<Chapter, Int>, JpaSpecificationExecutor<Chapter> {

    //根据章节名字查询
    // SELECT * FROM CHAPTER C WHERE C.CHAPTER_NAME =
    fun findByChapterName(Chapter: String): Optional<Chapter>

    /**
     * 根据章节名称判断章节是否存在
     * @param name 章节名称
     * @return true-存在 否则 false
     */
    fun existsByChapterName(name: String): Boolean

    //根据 课程ID 来查询
    fun findByCourseId(courseId: Int): List<Chapter>
}
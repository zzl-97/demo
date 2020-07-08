package com.huayei.course.service

import com.huayei.course.dto.ChapterDto
import com.huayei.course.event.Chapter
import com.huayei.course.repository.ChapterRepostitory
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody
import javax.persistence.criteria.Predicate

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:18
 *@Since 1.0
 **/


@Service
class ChapterService(

    var chapterRepostitory: ChapterRepostitory
) {

    fun selectChapterName(ChapterNike: String) = chapterRepostitory.findByChapterName(ChapterNike);

    //根据课程ID来查询 章节
    fun selectChapter(courseId: Int) = chapterRepostitory.findByCourseId(courseId);

    /**
     * 添加章节
     *  @param
     */
    fun addChapter(chapter: Chapter) = chapterRepostitory.save(chapter);

    /**
     * 查询章节
     */
    fun selectChapterAll(@RequestBody chapterDto: ChapterDto): List<Chapter> {
        val chapter = chapterDto.entity();
        val spec: Specification<Chapter?> =
            Specification<Chapter?> { root, query, criteriaBuilder -> //获取数据库字段
                val chapterName = root.get<Chapter>("chapterName")
                val courseId = root.get<Chapter>("courseId")
                //构造查询 第一个参数 path属性参数  第二个 就是取值
                var p1: Predicate? = null
                //将查询条件组合在一起()
                if (chapter.chapterName !== "") {
                    val p2 = criteriaBuilder.equal(chapterName, chapter.chapterName)
                    p1 = if (p1 != null) {
                        criteriaBuilder.and(p1, p2)
                    } else {
                        p2
                    }
                }
                if (chapter.courseId !== "") {
                    val p2 = criteriaBuilder.equal(courseId, chapter.courseId)
                    p1 = if (p1 != null) {
                        criteriaBuilder.and(p1, p2)
                    } else {
                        p2
                    }
                }
                p1!!
            }
        return chapterRepostitory.findAll(spec)
    }
}
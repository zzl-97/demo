package com.huayei.domain.course.service

import com.huayei.domain.course.entity.Chapter
import com.huayei.domain.course.repository.ChapterRepository
import com.huayei.domain.course.request.ChapterReq
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.domain.Specification
import org.springframework.stereotype.Service
import javax.persistence.criteria.Predicate


/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:18
 *@Since 1.0
 **/
@Service
class ChapterService(

    var chapterRepository: ChapterRepository
) {

    fun getChapter(chapterName: String) = chapterRepository.findByChapterName(chapterName)

    //根据课程ID来查询 章节
    fun getChaptersOf(courseId: Int) = chapterRepository.findByCourseId(courseId)

    /**
     * 添加章节  // 新增、修改、删除时需要对部分参数进行验证
     *  @param
     */
    fun addChapter(chapter: Chapter) = chapterRepository.save(chapter)

    /**
     * 动态查询章节信息
     * @param form 查询信息
     */
    fun getChapters(form: ChapterReq): Page<Chapter> {
        val pageable: Pageable = PageRequest.of(0, 10)
        return chapterRepository.findAll(this.getSpec(form), pageable)
    }

    private fun getSpec(form: ChapterReq): Specification<Chapter> {
        return Specification { root, query, cb ->
            val list = ArrayList<Predicate>()
            if (!form.name.isNullOrBlank()) {
                list.add(cb.equal(root.get<String>("chapterName"), form.name))
            }
            // !=   <>
            form.courseId?.let {
                list.add(cb.equal(root.get<String>("courseId"), form.courseId))
            }
            val p = arrayOfNulls<Predicate>(list.size)
            cb.and(*list.toArray(p))
        }
    }
}
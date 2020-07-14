package com.huayei.controller.course

import com.huayei.base.BaseResp
import com.huayei.base.PageResp
import com.huayei.domain.course.dto.ChapterDto
import com.huayei.domain.course.repository.ChapterRepository
import com.huayei.domain.course.service.ChapterService
import com.huayei.domain.course.request.ChapterReq
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

/**
 *@Description 章节的controller
 *Author zzl@huayei.com
 *Date 2020/7/8 10:18
 *@Since 1.0
 **/
@RestController
@CrossOrigin//跨域
@RequestMapping("/chapters")
class ChapterController(val chapterService: ChapterService, val chapterRepository: ChapterRepository) {

    /**
     * 添加章节
     * @param
     */
    @PostMapping("/add")
    fun addChapter(@RequestBody chapter: ChapterDto): BaseResp {
        //先查询章节名字是否存在
//        val oldChapter: Chapter? = chapter.chapterName?.let { chapterService.selectChapterName(it) }
        if (chapterRepository.existsByChapterName(chapter.chapterName!!)) {
            return BaseResp(status = 1,message = "章节名称已存在")
        }

        chapterService.addChapter(chapter.entity())
        return BaseResp(status = 0,message = "章节添加成功",data = chapter)
    }

    /**
     * 删除章节
     * @param chapterId 章节ID
     */

    @DeleteMapping("/{chapterId}")
    fun deleteChapter(@PathVariable chapterId : Int):ChapterDto{
        //先查询 后删除 //还有作业还没删除 作业功能完成再删除
        chapterRepository.findById(chapterId).map {
            chapterRepository.deleteById(chapterId);
        }.orElse(null)
        return ChapterDto(message = "删除章节成功")
    }

    /**
     * 修改章节
     * @param chapterId 章节ID
     */
    @PutMapping("/{chapterId}")
    fun updateChapter(@PathVariable chapterId :Int, @Validated @RequestBody chapter: ChapterDto):ChapterDto{
        //先查询是否存在
        chapterRepository.findById(chapterId).map { existsChapter ->
            existsChapter.courseId?.let {

            }

            chapterRepository.save(existsChapter)
        }
        return ChapterDto(message = "修改章节成功")
    }


    /**
     * 查询操作
     */
    @PostMapping("")
    fun selectChapter(@RequestBody form: ChapterReq): PageResp {

        val result = chapterService.getChapters(form)
        val data = result.content.map {
            it.dto()
        }
        return PageResp(page = form.page, size = form.size, total = result.totalElements, data = data)
    }
}
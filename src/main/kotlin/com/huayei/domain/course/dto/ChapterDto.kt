package com.huayei.domain.course.dto

import com.huayei.domain.course.entity.Chapter
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:21
 *@Since 1.0
 **/
data class ChapterDto(

    @get: NotNull
    var chapterId: Long? = null, //章节ID

    @get: Size(max = 256)
    var chapterName: String? = null, //章节名

    @get: NotBlank
    var courseware: String? = null, //课件路径

    var courseId: String? = null,//课程ID

    var message: String? = null
) {

    fun entity() :Chapter{
        return Chapter(
            chapterId = chapterId,
            chapterName = chapterName,
            courseware = courseware,
            courseId = courseId
        )
    }
}
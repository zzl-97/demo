package com.huayei.course.dto

import com.huayei.course.event.Chapter

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 10:21
 *@Since 1.0
 **/


data class ChapterDto(
    var chapterId: Int? = null, //章节ID

    var chapterName: String? = null,//章节名

    var courseware: String? = null,//课件路径

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
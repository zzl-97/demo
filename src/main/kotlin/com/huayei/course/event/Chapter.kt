package com.huayei.course.event

import com.huayei.course.dto.ChapterDto
import java.util.*
import javax.persistence.*

/**
 *@Description TODO
 *Author zzl@huayei.com
 *Date 2020/7/8 9:00
 *@Since 1.0
 **/

//章节表
@Entity
@Table(name = "t_chapter")
data class Chapter(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)//序列
    var chapterId: Int? = null, //章节ID

    var chapterName: String? = null,//章节名

    var courseware: String? = null,//课件路径

    var courseId: String? = null, //课程ID

    var createdDate: Date? = null // 创建时间
) {
    fun dto(): ChapterDto {

        return ChapterDto(
            chapterId = chapterId,
            chapterName = chapterName,
            courseware = courseware,
            courseId = courseId
        )
    }
}
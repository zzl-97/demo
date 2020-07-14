package com.huayei.domain.course.entity

import com.huayei.domain.course.dto.WordDto
import java.util.*
import javax.persistence.*

/**
 *@Description 作业的实体
 *Author zzl@huayei.com
 *Date 2020/7/8 17:19
 *@Since 1.0
 **/
@Entity
@Table(name = "t_word")
data class Word(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var wordId: Long? = null, //工作ID

    var wordName: String? = null, //作业名称

    var wordContent: String? = null, //作业内容


    var wordTime: Date = Date(), //作业时间

    var chapterId: Int? = null, //章节ID

    var wordUrl: String? = null //作业路径
) {

    fun dto(): WordDto {

        return WordDto(
            wordId = wordId,
            wordName = wordName,
            wordContent = wordContent,
            wordTime = wordTime,
            chapterId = chapterId,
            wordUrl = wordUrl
        )
    }
}
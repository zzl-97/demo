package com.huayei.domain.course.dto

import com.huayei.domain.course.entity.Word
import java.util.*

data class WordDto(

    var wordId: Long? = null, //工作ID

    var wordName: String? = null, //作业名称

    var wordContent: String? = null, //作业内容

    var wordTime: Date? = null, //作业时间

    var chapterId: Int? = null, //章节ID

    var wordUrl: String? = null, //作业路径

    var message: String? = null
) {

    fun entity(): Word {

        return Word(
            wordId = wordId,
            wordName = wordName,
            wordContent = wordContent,
//            wordTime = wordTime,
            chapterId = chapterId,
            wordUrl = wordUrl
        )
    }
}
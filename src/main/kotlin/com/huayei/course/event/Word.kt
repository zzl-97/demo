package com.huayei.course.event

import com.huayei.course.dto.WordDto
import org.springframework.data.annotation.CreatedDate
import java.util.*
import javax.persistence.*

/**
 *@Description TODO
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

//    @CreatedDate
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
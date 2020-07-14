package com.huayei.exam.testQuestions.event


import com.huayei.exam.testQuestions.dto.TestPaperDto
import javax.persistence.*
import javax.validation.constraints.NotBlank

/**
* @Description 试卷表
* @Author liuh@huayei.com
* @Date 2020/7/10 9:38
* @Since 1.0
*
*/
@Entity
@Table(name = "TEST_PAPERS")
data class TestPaper(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var paperId: Long? = null,//试卷id

    var paperName: String? = null,//试卷名

    var courseId: Long? =null,//课程id

    var paperState: Int? =0//考试状态0-启用，1-禁用

) {
    fun dto(): TestPaperDto {
        return TestPaperDto(paperId = paperId,
            paperName = paperName,
            courseId = courseId,
            paperState = paperState)
    }
}
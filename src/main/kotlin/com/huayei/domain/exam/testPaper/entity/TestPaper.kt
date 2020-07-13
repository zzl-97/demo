package com.huayei.exam.testQuestions.event


import com.huayei.exam.testQuestions.dto.TestPaperDto
import javax.persistence.*

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
    var paperId : Long ?= null,//试卷id

    var paperName : String ?= null,//试卷名

    var courseId : Int ?=null//课程id

) {
    fun dto() : TestPaperDto {
        return TestPaperDto( paperId = paperId, paperName = paperName, courseId = courseId )
    }
}
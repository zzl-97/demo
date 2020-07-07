package com.huayei.testQuestions.event

import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.dto.TestPaperDto
import javax.persistence.*

@Entity
@Table(name = "TEST_PAPERS")
data class TestPaper(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var paperId : Int ?= null,//试卷id

    var paperName : String ?= null//试卷名

) {
    fun dto() : TestPaperDto {
        return TestPaperDto( paperId = paperId, paperName = paperName )
    }
}
package com.huayei.exam.testQuestions.event


import com.huayei.exam.testQuestions.dto.TestPaperDto
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
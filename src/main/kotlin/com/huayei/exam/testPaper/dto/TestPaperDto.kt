package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestPaper
import javax.persistence.Column

data class TestPaperDto (

    @Column(nullable = false,length = 64)
    var paperId : Int ?= null,

    @Column(nullable = false,length = 64)
    var paperName : String ?= null,

    @Column(length = 64)
    var courseId : Int ?= null

) {
    fun entity() : TestPaper {
        return TestPaper( paperId = paperId, paperName = paperName, courseId = courseId )
    }
}
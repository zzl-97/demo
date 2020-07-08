package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestPaper

data class TestPaperDto (

    var paperId : Int ?= null,

    var paperName : String ?= null,

    var courseId : Int ?= null

) {
    fun entity() : TestPaper {
        return TestPaper( paperId = paperId, paperName = paperName, courseId = courseId )
    }
}
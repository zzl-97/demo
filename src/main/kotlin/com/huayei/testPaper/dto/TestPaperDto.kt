package com.huayei.testQuestions.dto

import com.huayei.testQuestions.event.Course
import com.huayei.testQuestions.event.TestPaper

data class TestPaperDto (

    var paperId : Int ?= null,

    var paperName : String ?= null

) {
    fun entity() : TestPaper {
        return TestPaper( paperId = paperId, paperName = paperName )
    }
}
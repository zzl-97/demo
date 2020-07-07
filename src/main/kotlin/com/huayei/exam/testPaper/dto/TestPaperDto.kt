package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestPaper

data class TestPaperDto (

    var paperId : Int ?= null,

    var paperName : String ?= null

) {
    fun entity() : TestPaper {
        return TestPaper( paperId = paperId, paperName = paperName )
    }
}
package com.huayei.testQuestions.dto

import com.huayei.testQuestions.event.Course
import com.huayei.testQuestions.event.TestQuestions

data class TestQuestionsDto (

    var questionId : Int ?= null,

    var questionName : String ?= null,

    var questionType : String ?= null,

    var answer : String ?= null,

    var optionA : String ?= null,

    var optionB : String ?= null,

    var optionC : String ?= null,

    var optionD : String ?= null,

    var courseId : Int ?=null

) {
    fun entity() : TestQuestions {
        return TestQuestions( questionName = questionName, questionType = questionType, answer = answer,
            optionA = optionA, optionB = optionB, optionC = optionC, optionD = optionD )
    }
}
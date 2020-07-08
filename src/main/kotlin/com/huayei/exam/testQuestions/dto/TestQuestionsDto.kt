package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestQuestions
import javax.persistence.Column

data class TestQuestionsDto (

    var questionId : Int ?= null,

    var questionName : String ?= null,

    var questionType : String ?= null,

    var answer : String ?= null,

    @Column(length = 512)
    var optionA : String ?= null,

    @Column(length = 512)
    var optionB : String ?= null,

    @Column(length = 512)
    var optionC : String ?= null,

    @Column(length = 512)
    var optionD : String ?= null,

    var courseId : Int ?=null

) {
    fun entity() : TestQuestions {
        return TestQuestions( questionName = questionName, questionType = questionType, answer = answer,
            optionA = optionA, optionB = optionB, optionC = optionC, optionD = optionD )
    }
}
package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestQuestions
import javax.persistence.Column

data class TestQuestionsDto (

    @Column(nullable = false,length = 64)
    var questionId: Long? = null,

    @Column(nullable = false,length = 512)
    var questionName: String? = null,

    @Column(nullable = false)
    var questionType: String? = null,

    @Column(nullable = false,length = 512)
    var answer: String? = null,

    @Column(length = 64)
    var optionA: String? = null,

    @Column(length = 64)
    var optionB: String? = null,

    @Column(length = 64)
    var optionC: String? = null,

    @Column(length = 64)
    var optionD: String? = null,

    @Column(nullable = false)
    var courseId: Int? =null

) {
    fun entity(): TestQuestions {
        return TestQuestions( questionName = questionName, questionType = questionType, answer = answer,
            optionA = optionA, optionB = optionB, optionC = optionC, optionD = optionD )
    }
}
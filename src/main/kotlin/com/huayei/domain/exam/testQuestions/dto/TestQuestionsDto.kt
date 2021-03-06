package com.huayei.exam.testQuestions.dto

import com.huayei.exam.testQuestions.event.TestQuestions
import javax.persistence.Column
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class TestQuestionsDto (
    @get: NotNull
    @get: Size(max = 64)
    var questionId: Long? = null,

    @get: NotNull
    @get: Size(max = 512)
    var questionName: String? = null,

    @get: NotNull
    var questionType: String? = null,

    @get: NotNull
    @get: Size(max = 512)
    var answer: String? = null,

    @get: Size(max = 64)
    var optionA: String? = null,

    @get: Size(max = 64)
    var optionB: String? = null,

    @get: Size(max = 64)
    var optionC: String? = null,

    @get: Size(max = 64)
    var optionD: String? = null,

    @get: NotNull
    var courseId: Long? =null

) {
    fun entity(): TestQuestions {
        return TestQuestions(questionName = questionName,
            questionType = questionType,
            answer = answer,
            optionA = optionA,
            optionB = optionB,
            optionC = optionC,
            optionD = optionD )
    }
}
package com.huayei.testQuestions.event

import com.huayei.testQuestions.dto.CourseDto
import com.huayei.testQuestions.dto.TestQuestionsDto
import javax.persistence.*

@Entity
@Table(name = "TEST_QUESTIONS")
data class TestQuestions(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var questionId : Int ?= null,

    var questionName : String ?= null,

    var questionType : String ?= null,

    var answer : String ?= null,

    var optionA : String ?= null,

    var optionB : String ?= null,

    var optionC : String ?= null,

    var optionD : String ?= null,

    var courseId: Int? = null

) {
    fun dto() : TestQuestionsDto {
        return TestQuestionsDto( questionId = questionId, questionName = questionName, questionType = questionType,
            answer = answer, optionA = optionA, optionB = optionB, optionC = optionC, optionD = optionD, courseId = courseId)
    }
}
package com.huayei.exam.testQuestions.event

import com.huayei.exam.testQuestions.dto.TestQuestionsDto
import javax.persistence.*

/**
* @Description 试题表
* @Author liuh@huayei.com
* @Date 2020/7/10 9:44
* @Since 1.0
*
*/
@Entity
@Table(name = "TEST_QUESTIONS")
data class TestQuestions(

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var questionId: Long? = null,// 试题id

    var questionName: String? = null,// 试题名

    var questionType: String? = null,// 试题类型

    var answer: String? = null,// 答案

    var optionA: String? = null,// 选项A

    var optionB: String? = null,// 选项B

    var optionC: String? = null,// 选项C

    var optionD: String? = null,// 选项D

    var courseId: Long? = null// 课程id

) {
    fun dto(): TestQuestionsDto {
        return TestQuestionsDto(questionId = questionId,
            questionName = questionName,
            questionType = questionType,
            answer = answer,
            optionA = optionA,
            optionB = optionB,
            optionC = optionC,
            optionD = optionD,
            courseId = courseId)
    }
}
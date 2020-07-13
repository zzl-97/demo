package com.huayei.exam.testPaper.event

import javax.persistence.*

/**
* @Description 试卷试题中间表
* @Author liuh@huayei.com
* @Date 2020/7/10 9:40
* @Since 1.0
*
*/
@Entity
@Table(name = "TEST_PAPERS_QUESTIONS")
data class TestPaperQuestion(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var paperQuestionId: Long? = null,

    var paperId: Long? = null,

    var questionId: Long? =null
)